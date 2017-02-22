package com.tywy.sc.controller.back;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.constant.CfgConstant;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.data.model.WebsiteSalesT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.WebsiteSalesTService;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteSalesTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-21 05:15:37 
* @Copyright：
 */
@Controller
public class WebsiteSalesTController extends BaseController {
	
	@Resource
	private WebsiteSalesTService websiteSalesTService;
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@RequestMapping(value = "system/websiteSalesTList")
	public String websiteSalesTList(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "website_sales_image");
		ConfigInfo configImageInfo = configInfoService.selectEntity(imageParams);
		if(configImageInfo != null){
			request.setAttribute("configImageInfo", configImageInfo);
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_sales_content");
		ConfigInfo configInfo = configInfoService.selectEntity(params);
		if(configInfo != null){
			request.setAttribute("configInfo", configInfo);
		}
		return "back/website_sales_list";
	}
	
	@RequestMapping(value = "system/websiteSalesTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteSalesT> websiteSalesTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteSalesT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteSalesT> pageInfo = new PageInfo<WebsiteSalesT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		websiteSalesTService.selectAll(info, pageInfo);
		List<WebsiteSalesT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			return pageInfo;
		}
		List<String> categoryIdList = new ArrayList<String>();
		for(WebsiteSalesT entity : list){
			categoryIdList.add(entity.getCategoryId());
		}
		List<WebsiteCategoryT> categoryList = websiteCategoryTService.selectByIds(categoryIdList);
		if(categoryList == null || categoryList.isEmpty()){
			return pageInfo;
		}
		Map<String,String> categoryMap = new HashMap<String,String>();
		for(WebsiteCategoryT category : categoryList){
			categoryMap.put(category.getId(), category.getCategoryName());
		}
		for(WebsiteSalesT entity : list){
			entity.setCategoryName(categoryMap.get(entity.getCategoryId()));
		}
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteSalesTAjaxAll")
	@ResponseBody
	public List<WebsiteSalesT> websiteSalesTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteSalesT info, Integer page,
			Integer rows) {
		List<WebsiteSalesT> results= websiteSalesTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteSalesTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteSalesTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteSalesT info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setCreateDate(new Date());
			info.setIsDelete("0");
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteSalesTService.insert(info);
			msg = "保存失败！";
		} else {
			result = websiteSalesTService.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteSalesTAjaxSaveSettings")
	@ResponseBody
	public Map<String,Object> websiteSalesTAjaxSaveSettings(HttpServletRequest request,
			HttpServletResponse response,StreamVO streamVO,String operType,String configValue) {
		int result = 0;
		String msg = "";
		
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "website_sales_image");
		ConfigInfo configImageInfo = configInfoService.selectEntity(imageParams);
		if (configImageInfo == null) {
			configImageInfo = new ConfigInfo();
			configImageInfo.setId(UUIDUtil.getUUID());
			configImageInfo.setConfigKey("website_sales_image");
			configImageInfo.setCreateDate(new Date());
			configImageInfo.setCreateUser(getSessionUser(request).getId());
			configImageInfo.setIsDelete("0");
			configImageInfo.setStatus("1");
			result = configInfoService.insertWithImage(configImageInfo,streamVO);
			msg = "保存失败！";
			if(result <= 0){
				return getJsonResult(result, "操作成功",msg);
			}
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isNotBlank(operType)){
				result = configInfoService.updateWithImage(configImageInfo,streamVO);
				if(result <= 0){
					msg = "修改失败！";
					return getJsonResult(result, "操作成功",msg);
				}
			}
		}
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_sales_content");
		ConfigInfo configInfo = configInfoService.selectEntity(params);
		if (configInfo == null) {
			configInfo = new ConfigInfo();
			configInfo.setId(UUIDUtil.getUUID());
			configInfo.setConfigKey("website_sales_content");
			configInfo.setConfigValue(configValue);
			configInfo.setCreateDate(new Date());
			configInfo.setCreateUser(getSessionUser(request).getId());
			configInfo.setIsDelete("0");
			configInfo.setStatus("1");
			result = configInfoService.insert(configInfo);
			msg = "保存失败！";
			
		} else {
			//根据opertyp判断是否需要上传
			configInfo.setConfigValue(configValue);
			result = configInfoService.update(configInfo);
			msg = "修改失败！";
		}
		
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteSalesTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteSalesTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteSalesT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteSalesTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteSalesTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteSalesTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteSalesT info) {
		int result = 0;
		try {
			result = websiteSalesTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "操作失败！");
	}
	
	@RequestMapping(value = "system/websiteSalesMap")
	public String websiteSalesMap(HttpServletRequest request,HttpServletResponse response) {
		return "back/website_sales_map";
	}
	
	@RequestMapping(value = "system/websiteSalesGenerateMap")
	@ResponseBody
	public Map<String,Object> websiteSalesGenerateMap(HttpServletRequest request,HttpServletResponse response) {
		
		WebsiteSalesT hqInfo = new WebsiteSalesT();
		hqInfo.setArea(CfgConstant.DEFAULT_HQ_NAME);
		hqInfo.setLongitude(CfgConstant.DEFAULT_HQ_POINT_LNG);
		hqInfo.setLatitude(CfgConstant.DEFAULT_HQ_POINT_LAT);
		Map<String,Object> areaMap = new HashMap<String,Object>();
		areaMap.put("hqInfo", hqInfo);
		
		WebsiteSalesT info = new WebsiteSalesT();
		info.setStatus("1");
		info.setIsDelete("0");
		List<WebsiteSalesT> list = websiteSalesTService.selectAll(info);
		areaMap.put("areas", list);
		return areaMap;
	}
}
