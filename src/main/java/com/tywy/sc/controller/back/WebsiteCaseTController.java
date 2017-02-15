package com.tywy.sc.controller.back;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.WebsiteCaseTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteCaseTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-16 02:32:48 
* @Copyright：
 */
@Controller
public class WebsiteCaseTController extends BaseController {
	
	@Resource
	private WebsiteCaseTService websiteCaseTService;
	
	@Resource
	private ConfigInfoService configInfoService;

	@RequestMapping(value = "system/websiteCaseTList")
	public String websiteCaseTList(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_case_content");
		ConfigInfo info = configInfoService.selectEntity(params);
		request.setAttribute("configInfo", info);
		return "back/website_case_list";
	}
	
	@RequestMapping(value = "system/websiteCaseTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteCaseT> websiteCaseTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteCaseT> pageInfo = new PageInfo<WebsiteCaseT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		info.setSort("createDate");
		info.setOrder("asc");
		websiteCaseTService.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteCaseTAjaxAll")
	@ResponseBody
	public List<WebsiteCaseT> websiteCaseTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info, Integer page,
			Integer rows) {
		List<WebsiteCaseT> results = websiteCaseTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteCaseTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCaseTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setCreateUser(getSessionUser(request).getId());
			info.setCreateDate(new Date());
			info.setIsDelete("0");
			result = websiteCaseTService.insert(info);
			msg = "保存失败！";
		} else {
			result = websiteCaseTService.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteCaseTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteCaseTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteCaseTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteCaseTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteCaseTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info) {
		int result = 0;
		try {
			result = websiteCaseTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
