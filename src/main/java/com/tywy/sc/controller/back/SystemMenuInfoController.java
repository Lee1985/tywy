package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.SystemMenuInfo;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.SystemMenuInfoService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: SystemMenuInfoController 
* @Description: 控制层 
* @author lipeng 
* @date 2016-11-22 22:14:16 
* @Copyright：
 */
@Controller
public class SystemMenuInfoController extends BaseController {
	@Resource
	private SystemMenuInfoService service;

	@RequestMapping(value = "/systemMenuInfoList")
	public String systemMenuInfoList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/system_menu_info_list";
	}

	@RequestMapping(value = "/systemMenuInfoAjaxPage")
	@ResponseBody
	public PageInfo<SystemMenuInfo> systemMenuInfoAjaxPage(HttpServletRequest request,
			HttpServletResponse response, SystemMenuInfo info, Integer page,
			Integer rows) {
		PageInfo<SystemMenuInfo> pageInfo = new PageInfo<SystemMenuInfo>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/systemMenuInfoAjaxAll")
	@ResponseBody
	public List<SystemMenuInfo> systemMenuInfoAjaxAll(HttpServletRequest request,
			HttpServletResponse response, SystemMenuInfo info, Integer page,
			Integer rows) {
		List<SystemMenuInfo> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/systemMenuInfoAjaxSave")
	@ResponseBody
	public Map<String,Object> systemMenuInfoAjaxSave(HttpServletRequest request,
			HttpServletResponse response, SystemMenuInfo info) {
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

	@RequestMapping(value = "/systemMenuInfoAjaxDelete")
	@ResponseBody
	public Map<String,Object> systemMenuInfoAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, SystemMenuInfo info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
