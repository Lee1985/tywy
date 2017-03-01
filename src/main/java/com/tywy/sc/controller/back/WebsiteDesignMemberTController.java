package com.tywy.sc.controller.back;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.WebsiteDesignMemberT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.WebsiteDesignMemberTService;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteDesignMemberTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-28 16:21:37 
* @Copyright：
 */
@Controller
public class WebsiteDesignMemberTController extends BaseController {
	
	@Resource
	private WebsiteDesignMemberTService websiteDesignMemberTService;
	
	@Resource
	private ConfigInfoService configInfoService;

	@RequestMapping(value = "system/websiteDesignMemberTList")
	public String websiteDesignMemberTList(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "website_design_member_nav");
		ConfigInfo configImageInfo = configInfoService.selectEntity(imageParams);
		if(configImageInfo != null){
			request.setAttribute("configImageInfo", configImageInfo);
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_design_member_content");
		ConfigInfo configInfo = configInfoService.selectEntity(params);
		if(configInfo != null){
			request.setAttribute("configInfo", configInfo);
		}
		return "back/website_design_member_list";
	}

	@RequestMapping(value = "system/websiteDesignMemberTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteDesignMemberT> websiteDesignMemberTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignMemberT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteDesignMemberT> pageInfo = new PageInfo<WebsiteDesignMemberT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		info.setSort("orderList");
		info.setOrder("asc");
		websiteDesignMemberTService.selectAll(info, pageInfo);
		return pageInfo;
	}
	
	@RequestMapping(value = "system/websiteDesignMemberTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteDesignMemberTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignMemberT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteDesignMemberTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteDesignMemberTService.update(info);
			}else{
				result = websiteDesignMemberTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功", msg);
	}

	@RequestMapping(value = "system/websiteDesignMemberTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteDesignMemberTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignMemberT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteDesignMemberTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteDesignMemberTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteDesignMemberTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignMemberT info) {
		int result = 0;
		try {
			result = websiteDesignMemberTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "操作失败！");
	}
	
	@RequestMapping(value = "system/websiteDesignMemberTAjaxSaveSettings")
	@ResponseBody
	public Map<String,Object> websiteDesignMemberTAjaxSaveSettings(HttpServletRequest request,
			HttpServletResponse response,StreamVO streamVO,String operType,String configValue) {

		int result = 0;
		String msg = "";
		
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "website_design_member_nav");
		ConfigInfo configImageInfo = configInfoService.selectEntity(imageParams);
		if (configImageInfo == null) {
			configImageInfo = new ConfigInfo();
			configImageInfo.setId(UUIDUtil.getUUID());
			configImageInfo.setConfigKey("website_design_member_nav");
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
		params.put("configKey", "website_design_member_content");
		ConfigInfo configInfo = configInfoService.selectEntity(params);
		if (configInfo == null) {
			configInfo = new ConfigInfo();
			configInfo.setId(UUIDUtil.getUUID());
			configInfo.setConfigKey("website_design_member_content");
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
}
