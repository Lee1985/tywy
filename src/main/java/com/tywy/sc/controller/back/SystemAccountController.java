package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tywy.constant.SessionConstants;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.SystemUserInfo;
import com.tywy.sc.services.SystemRoleAuthorityService;
import com.tywy.sc.services.SystemUserInfoService;
import com.tywy.utils.CipherUtil;

@Controller
public class SystemAccountController extends BaseController{

	@Resource
	private SystemUserInfoService systemUserService;
	
	@Resource
	private SystemRoleAuthorityService systemRoleAuthorityService;
				
	public final static Log log = LogFactory.getLog(SystemAccountController.class);
	
	/**
	 * 进入系统的登陆页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="welcome" , method={RequestMethod.GET , RequestMethod.POST})
	public String welcome(HttpServletRequest request , Model model) {
		String error = (String)request.getAttribute("LOGIN_ERROR");
		model.addAttribute("LOGIN_ERROR", error);
		return "framework/login";
	}
	
	@RequestMapping(value="/login" , method={RequestMethod.GET , RequestMethod.POST})
	public String login(HttpServletRequest request , HttpServletResponse response , String userId,String userPwd ,@RequestParam(required=false) String validateCode ) {
		
		log.debug("begin : LoginAction ----> login");
		String sessValidCode = (String)request.getSession().getAttribute("LoginAuthCode");
		if (sessValidCode == null || !sessValidCode.equalsIgnoreCase(validateCode)) {
			log.error("LoginAction ----> login ---->sessValidCode : "+sessValidCode);
			request.setAttribute("LOGIN_ERROR", "验证码输入错误.");
			return "forward:/index.jsp";
		}
		
		String password = CipherUtil.generatePassword(userPwd);
		SystemUserInfo systemUser = new SystemUserInfo();
		systemUser.setUserPwd(password);
		systemUser.setUserId(userId);
		systemUser = systemUserService.selectEntity(systemUser);
			
		//判断用户合法性
		if (null == systemUser) {
			request.setAttribute("LOGIN_ERROR", "用户不存在或密码错误.");
			return "forward:/index.jsp";

		} else if (systemUser.getStatus() == 0) {
			request.setAttribute("LOGIN_ERROR", "用户被禁用,请与上级管理员联系进行启用.");
			return "forward:/index.jsp";
		}else {
			//查询角色对应的菜单
			String roleId = "";
			roleId = systemUser.getRoleId();
			SystemUserInfo condition = new SystemUserInfo();
			condition.setRoleId(roleId);
			List<Map<String, Object>> permissUrls = systemRoleAuthorityService.selectPermissUrl(condition);
			request.getSession(true).setAttribute(SessionConstants.SESSION_PERMISSURL, permissUrls);
			request.getSession(true).setAttribute(SessionConstants.SESSION_BACK_USER,systemUser);
			
			request.getSession().setAttribute(SessionConstants.SESSION_BACK_USER_FLAG, 1);
			return "redirect:/main.do";
		}
	}
	
	@RequestMapping(value="/main" , method={RequestMethod.GET , RequestMethod.POST})
	public String main(HttpServletRequest request , HttpServletResponse response){
		return "framework/main";
	}
	
	@RequestMapping(value="/logout" , method={RequestMethod.GET , RequestMethod.POST})
	public String logout(HttpServletRequest request , HttpServletResponse response) {		
		request.getSession().removeAttribute(SessionConstants.SESSION_PERMISSURL);
		request.getSession().removeAttribute(SessionConstants.SESSION_BACK_USER);
		request.getSession().removeAttribute(SessionConstants.SESSION_BACK_USER_FLAG);
		return "redirect:/welcome.do";
	}		
}
