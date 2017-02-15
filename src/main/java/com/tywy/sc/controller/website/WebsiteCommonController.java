package com.tywy.sc.controller.website;

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
import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.sc.services.WebsiteBrandTService;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.WebsiteIntroductionTService;

@Controller
public class WebsiteCommonController extends BaseController{
	
	@Resource
	private WebsiteIntroductionTService websiteIntroductionTService;
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;
	
	@Resource
	private WebsiteBrandTService websiteBrandTService;
	
	@RequestMapping(value = "aboutMenu")
	@ResponseBody
	public List<WebsiteIntroductionT> aboutMenu(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", "0");
		params.put("status", "1");
		return websiteIntroductionTService.selectAll(params);
	}
	
	@RequestMapping(value = "newsMenu")
	@ResponseBody
	public List<WebsiteCategoryT> newsMenu(HttpServletRequest request,HttpServletResponse response) {
		WebsiteCategoryT info = new WebsiteCategoryT();
		info.setStatus(1);
		info.setCode("news");
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		return websiteCategoryTService.selectAll(info);
	}
	
	@RequestMapping(value = "brandMenu")
	@ResponseBody
	public List<WebsiteBrandT> brandMenu(HttpServletRequest request,HttpServletResponse response){
		WebsiteBrandT info = new WebsiteBrandT();
		info.setStatus("1");
		info.setIsDelete("0");
		info.setSort("createDate");
		info.setOrder("asc");
		return websiteBrandTService.selectAll(info);
	}
}
