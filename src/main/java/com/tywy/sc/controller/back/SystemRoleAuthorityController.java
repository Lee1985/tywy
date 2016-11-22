package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.SystemRoleAuthorityService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: SystemRoleAuthorityController 
* @Description: 控制层 
* @author lipeng 
* @date 2016-11-22 11:32:03 
* @Copyright：
 */
@Controller
public class SystemRoleAuthorityController extends BaseController {
	@Resource
	private SystemRoleAuthorityService service;

	@RequestMapping(value = "/systemRoleAuthorityList")
	public String systemRoleAuthorityList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/system_role_authority_list";
	}

	@RequestMapping(value = "/systemRoleAuthorityAjaxPage")
	@ResponseBody
	public PageInfo<SystemRoleAuthority> systemRoleAuthorityAjaxPage(HttpServletRequest request,
			HttpServletResponse response, SystemRoleAuthority info, Integer page,
			Integer rows) {
		PageInfo<SystemRoleAuthority> pageInfo = new PageInfo<SystemRoleAuthority>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/systemRoleAuthorityAjaxAll")
	@ResponseBody
	public List<SystemRoleAuthority> systemRoleAuthorityAjaxAll(HttpServletRequest request,
			HttpServletResponse response, SystemRoleAuthority info, Integer page,
			Integer rows) {
		List<SystemRoleAuthority> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/systemRoleAuthorityAjaxSave")
	@ResponseBody
	public Map<String,Object> systemRoleAuthorityAjaxSave(HttpServletRequest request,
			HttpServletResponse response, SystemRoleAuthority info) {
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

	@RequestMapping(value = "/systemRoleAuthorityAjaxDelete")
	@ResponseBody
	public Map<String,Object> systemRoleAuthorityAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, SystemRoleAuthority info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
