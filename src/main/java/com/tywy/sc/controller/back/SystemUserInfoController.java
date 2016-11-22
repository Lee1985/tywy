package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.SystemUserInfo;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.SystemUserInfoService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: SystemUserInfoController 
* @Description: 控制层 
* @author lipeng 
* @date 2016-11-22 11:11:20 
* @Copyright：
 */
@Controller
public class SystemUserInfoController extends BaseController {
	@Resource
	private SystemUserInfoService service;

	@RequestMapping(value = "/systemUserInfoList")
	public String systemUserInfoList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/system_user_info_list";
	}

	@RequestMapping(value = "/systemUserInfoAjaxPage")
	@ResponseBody
	public PageInfo<SystemUserInfo> systemUserInfoAjaxPage(HttpServletRequest request,
			HttpServletResponse response, SystemUserInfo info, Integer page,
			Integer rows) {
		PageInfo<SystemUserInfo> pageInfo = new PageInfo<SystemUserInfo>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/systemUserInfoAjaxAll")
	@ResponseBody
	public List<SystemUserInfo> systemUserInfoAjaxAll(HttpServletRequest request,
			HttpServletResponse response, SystemUserInfo info, Integer page,
			Integer rows) {
		List<SystemUserInfo> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/systemUserInfoAjaxSave")
	@ResponseBody
	public Map<String,Object> systemUserInfoAjaxSave(HttpServletRequest request,
			HttpServletResponse response, SystemUserInfo info) {
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

	@RequestMapping(value = "/systemUserInfoAjaxDelete")
	@ResponseBody
	public Map<String,Object> systemUserInfoAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, SystemUserInfo info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
