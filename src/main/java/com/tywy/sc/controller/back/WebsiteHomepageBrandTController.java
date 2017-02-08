package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.WebsiteHomepageBrandT;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WebsiteHomepageBrandTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteHomepageBrandTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-08 11:27:22 
* @Copyright：
 */
@Controller
public class WebsiteHomepageBrandTController extends BaseController {
	@Resource
	private WebsiteHomepageBrandTService service;

	@RequestMapping(value = "/websiteHomepageBrandTList")
	public String websiteHomepageBrandTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/website_homepage_brand_t_list";
	}

	@RequestMapping(value = "/websiteHomepageBrandTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteHomepageBrandT> websiteHomepageBrandTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteHomepageBrandT> pageInfo = new PageInfo<WebsiteHomepageBrandT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/websiteHomepageBrandTAjaxAll")
	@ResponseBody
	public List<WebsiteHomepageBrandT> websiteHomepageBrandTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info, Integer page,
			Integer rows) {
		List<WebsiteHomepageBrandT> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/websiteHomepageBrandTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteHomepageBrandTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info) {
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

	@RequestMapping(value = "/websiteHomepageBrandTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteHomepageBrandTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
