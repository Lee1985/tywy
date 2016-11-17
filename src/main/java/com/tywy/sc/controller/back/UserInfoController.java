package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.UserInfo;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.UserInfoService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: UserInfoController 
* @Description: 控制层 
* @author lipeng 
* @date 2016-11-17 16:48:35 
* @Copyright：
 */
@Controller
public class UserInfoController extends BaseController {
	@Resource
	private UserInfoService service;

	@RequestMapping(value = "/userInfoList")
	public String userInfoList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/user_info_list";
	}

	@RequestMapping(value = "/userInfoAjaxPage")
	@ResponseBody
	public PageInfo<UserInfo> userInfoAjaxPage(HttpServletRequest request,
			HttpServletResponse response, UserInfo info, Integer page,
			Integer rows) {
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/userInfoAjaxAll")
	@ResponseBody
	public List<UserInfo> userInfoAjaxAll(HttpServletRequest request,
			HttpServletResponse response, UserInfo info, Integer page,
			Integer rows) {
		List<UserInfo> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/userInfoAjaxSave")
	@ResponseBody
	public Map<String,Object> userInfoAjaxSave(HttpServletRequest request,
			HttpServletResponse response, UserInfo info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			result = service.insert(info);
			msg = "保存失败！";
		} else {
			result = service.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "/userInfoAjaxDelete")
	@ResponseBody
	public Map<String,Object> userInfoAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, UserInfo info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
