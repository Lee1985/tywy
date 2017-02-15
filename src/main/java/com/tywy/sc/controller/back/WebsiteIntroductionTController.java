package com.tywy.sc.controller.back;

import java.util.Date;
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
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.sc.services.WebsiteIntroductionTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteIntroductionTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-14 18:34:15 
* @Copyright：
 */
@Controller
public class WebsiteIntroductionTController extends BaseController {
	
	@Resource
	private WebsiteIntroductionTService websiteIntroductionTService;

	@RequestMapping(value = "system/websiteIntroductionTList")
	public String websiteIntroductionTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "back/website_introduction_list";
	}
	
	@RequestMapping(value = "system/websiteIntroductionTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteIntroductionT> websiteIntroductionTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteIntroductionT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteIntroductionT> pageInfo = new PageInfo<WebsiteIntroductionT>();
		info.setIsDelete("0");
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		websiteIntroductionTService.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteIntroductionTAjaxAll")
	@ResponseBody
	public List<WebsiteIntroductionT> websiteIntroductionTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteIntroductionT info, Integer page,
			Integer rows) {
		List<WebsiteIntroductionT> results= websiteIntroductionTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteIntroductionTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteIntroductionTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteIntroductionT info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setCreateUser(getSessionUser(request).getId());
			info.setCreateDate(new Date());
			info.setIsDelete("0");
			result = websiteIntroductionTService.insert(info);
			msg = "保存失败！";
		} else {
			result = websiteIntroductionTService.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteIntroductionTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteIntroductionTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteIntroductionT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteIntroductionTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteIntroductionTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteIntroductionTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteIntroductionT info) {
		int result = 0;
		try {
			result = websiteIntroductionTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
