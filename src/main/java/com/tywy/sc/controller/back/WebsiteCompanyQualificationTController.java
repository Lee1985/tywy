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

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCompanyQualificationT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCompanyQualificationTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteCompanyQualificationTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-14 19:10:05 
* @Copyright：
 */
@Controller
public class WebsiteCompanyQualificationTController extends BaseController {
	
	@Resource
	private WebsiteCompanyQualificationTService websiteCompanyQualificationTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@Resource
	private ConfigInfoService configInfoService;

	@RequestMapping(value = "system/websiteCompanyQualificationTList")
	public String websiteCompanyQualificationTList(HttpServletRequest request,HttpServletResponse response) {
		
		String configValue = configInfoService.getConfigValueByKey("website_company_qualification_nav");
		request.setAttribute("configValue", configValue);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteCompanyQualificationT> list = websiteCompanyQualificationTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "back/website_company_qualification_list";
		}
		
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteCompanyQualificationT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "back/website_company_qualification_list";
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteCompanyQualificationT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			pic.setFileSize(FileTool.convertFileSize(pic.getFsize()));
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("list", list);
		
		return "back/website_company_qualification_list";
	}
	
	@RequestMapping(value = "system/websiteCompanyQualificationTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteCompanyQualificationT> websiteCompanyQualificationTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteCompanyQualificationT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteCompanyQualificationT> pageInfo = new PageInfo<WebsiteCompanyQualificationT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		websiteCompanyQualificationTService.selectAll(info, pageInfo);
		return pageInfo;
	}
	
	@RequestMapping(value = "system/websiteCompanyQualificationTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCompanyQualificationTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCompanyQualificationT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteCompanyQualificationTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteCompanyQualificationTService.update(info);
			}else{
				result = websiteCompanyQualificationTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteCompanyQualificationTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteCompanyQualificationTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteCompanyQualificationT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteCompanyQualificationTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteCompanyQualificationNavTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCompanyQualificationNavTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCompanyQualificationT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "website_company_qualification_nav");
		ConfigInfo configImageInfo = configInfoService.selectEntity(imageParams);
		if (configImageInfo == null) {
			configImageInfo = new ConfigInfo();
			configImageInfo.setId(UUIDUtil.getUUID());
			configImageInfo.setConfigKey("website_company_qualification_nav");
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
		return getJsonResult(result, "操作成功",msg);
	}
}
