package com.tywy.sc.controller.back;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.WebsiteHomepageSalesT;
import com.tywy.sc.services.WebsiteHomepageSalesTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteHomepageSalesTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-03-07 15:58:14 
* @Copyright：
 */
@Controller
public class WebsiteHomepageSalesTController extends BaseController {
	
	@Resource
	private WebsiteHomepageSalesTService websiteHomepageSalesTService;

	@RequestMapping(value = "system/websiteHomepageSalesTList")
	public String websiteHomepageSalesTList(HttpServletRequest request,HttpServletResponse response) {
		return "back/website_homepage_sales_list";
	}

	@RequestMapping(value = "system/websiteHomepageSalesTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteHomepageSalesT> websiteHomepageSalesTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageSalesT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteHomepageSalesT> pageInfo = new PageInfo<WebsiteHomepageSalesT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		websiteHomepageSalesTService.selectAll(info, pageInfo);
		return pageInfo;
	}
	
	@RequestMapping(value = "system/websiteHomepageSalesTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteHomepageSalesTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageSalesT info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setIsDelete("0");
			info.setCreateUser(getSessionUser(request).getId());
			info.setCreateDate(new Date());
			result = websiteHomepageSalesTService.insert(info);
			msg = "保存失败！";
		} else {
			result = websiteHomepageSalesTService.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteHomepageSalesTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteHomepageSalesTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageSalesT info) {
		int result = 0;
		try {
			result = websiteHomepageSalesTService.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "操作失败！");
	}
	
	@RequestMapping(value = "system/websiteHomepageSalesTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteHomepageSalesTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageSalesT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteHomepageSalesTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "操作失败！");
	}
}
