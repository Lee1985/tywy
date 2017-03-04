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
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.data.model.WebsiteSalesT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.WebsiteSalesTService;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteSalesNetController extends BaseController{
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;
	
	@Resource
	private WebsiteSalesTService websiteSalesTService;
	
	@RequestMapping(value = "map")
	public String map(HttpServletRequest request,HttpServletResponse response) {
		
		//获取导航图
		String salesImageUrl = configInfoService.getConfigValueByKey("website_sales_image");
		request.setAttribute("salesImageUrl", salesImageUrl);
		
		//获取文字描述
		String salesContents = configInfoService.getConfigValueByKey("website_sales_content");
		request.setAttribute("salesContents", JsoupUtils.removeStyle(salesContents));
		
		//获取销售网络类别
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", 0);
		params.put("status", 1);
		params.put("status", 1);
		params.put("sort", "orderList");
		params.put("order", "asc");
		params.put("code", "district");
		List<WebsiteCategoryT> salesCateList = websiteCategoryTService.selectAll(params);
		request.setAttribute("salesCateList", salesCateList);
		
		//获取默认类别下的销售网络
		if(salesCateList != null && !salesCateList.isEmpty()){
			WebsiteCategoryT categoryInfo = salesCateList.get(0);
			Map<String,Object> salesParams = new HashMap<String,Object>();
			salesParams.put("isDelete", "0");
			salesParams.put("status", "1");
			salesParams.put("categoryId", categoryInfo.getId());
			List<WebsiteSalesT> salesList = websiteSalesTService.selectAll(salesParams);
			request.setAttribute("salesList", salesList);
		}
	
		return "website/map";
	}
	
	@RequestMapping(value = "websiteSalesGenerateMap")
	@ResponseBody
	public Map<String,Object> websiteSalesGenerateMap(HttpServletRequest request,HttpServletResponse response) {
		
		Map<String,Object> hqParams = new HashMap<String,Object>();
		hqParams.put("isHq", '1');
		WebsiteSalesT hqInfo = websiteSalesTService.selectEntity(hqParams);
		Map<String,Object> areaMap = new HashMap<String,Object>();
		areaMap.put("hqInfo", hqInfo);
		
		WebsiteSalesT info = new WebsiteSalesT();
		info.setStatus("1");
		info.setIsDelete("0");
		List<WebsiteSalesT> list = websiteSalesTService.selectAll(info);
		areaMap.put("areas", list);
		return areaMap;
	}
	
	@RequestMapping(value = "websiteSalesByCategory")
	@ResponseBody
	public List<WebsiteSalesT> websiteSalesByCategory(HttpServletRequest request,HttpServletResponse response,String categoryId) {
		Map<String,Object> salesParams = new HashMap<String,Object>();
		salesParams.put("isDelete", "0");
		salesParams.put("status", "1");
		salesParams.put("categoryId", categoryId);
		List<WebsiteSalesT> salesList = websiteSalesTService.selectAll(salesParams);
		return salesList;
	}
	
}
