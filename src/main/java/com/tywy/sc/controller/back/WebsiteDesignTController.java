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
import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteDesignTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteDesignTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-15 17:15:36 
* @Copyright：
 */
@Controller
public class WebsiteDesignTController extends BaseController {
	
	@Resource
	private WebsiteDesignTService websiteDesignTService;
	
	@Resource
	private ConfigInfoService configService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteDesignTList")
	public String websiteDesignTList(HttpServletRequest request,HttpServletResponse response,String id) {	
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_design_content");
		ConfigInfo configInfo = configService.selectEntity(params);
		if(configInfo == null){
			return "back/website_design_list";
		}
		request.setAttribute("configInfo", configInfo);
		
		params = new HashMap<String,Object>();
		params.put("configKey", "website_design_nav");
		ConfigInfo imageConfigInfo = configService.selectEntity(params);
		request.setAttribute("imageConfigInfo", imageConfigInfo);
		
		return "back/website_design_list";
	}
	
	@RequestMapping(value = "system/websiteDesignEdit")
	public String websiteDesignEdit(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_design_content");
		ConfigInfo configInfo = configService.selectEntity(params);
		if(configInfo == null){
			return "back/website_design_list";
		}
		request.setAttribute("configInfo", configInfo);	
		
		params = new HashMap<String,Object>();
		params.put("configKey", "website_design_nav");
		ConfigInfo imageConfigInfo = configService.selectEntity(params);
		request.setAttribute("imageConfigInfo", imageConfigInfo);
		
		return "back/website_design_edit";
	}
	
	@RequestMapping(value = "system/websiteDesignAblum")
	public String websiteDesignAblum(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteDesignT> list = websiteDesignTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "back/website_design_album_list";
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteDesignT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "back/website_design_album_list";
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteDesignT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			pic.setFileSize(FileTool.convertFileSize(pic.getFsize()));
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("list", list);
		return "back/website_design_album_list";
	}
	
	@RequestMapping(value = "system/websiteDesignTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteDesignT> websiteDesignTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteDesignT> pageInfo = new PageInfo<WebsiteDesignT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		websiteDesignTService.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteDesignTAjaxAll")
	@ResponseBody
	public List<WebsiteDesignT> websiteDesignTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info, Integer page,
			Integer rows) {
		List<WebsiteDesignT> results= websiteDesignTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteDesignTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteDesignTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteDesignTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传	
			if(StringUtils.isBlank(operType)){
				result = websiteDesignTService.update(info);
			}else{
				result = websiteDesignTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteDesignTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteDesignTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info) {
		int result = 0;
		try {
			result = websiteDesignTService.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value="system/websiteDesignTAjaxSaveSettings")
	@ResponseBody
	public Map<String,Object> websiteDesignTAjaxSaveSettings(HttpServletRequest request,
			HttpServletResponse response,StreamVO streamVO,String operType,String configValue){
		int result = 0;
		String msg = "";
		
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "website_design_nav");
		ConfigInfo configImageInfo = configService.selectEntity(imageParams);
		if (configImageInfo == null) {
			configImageInfo = new ConfigInfo();
			configImageInfo.setId(UUIDUtil.getUUID());
			configImageInfo.setConfigKey("website_design_nav");
			configImageInfo.setCreateDate(new Date());
			configImageInfo.setCreateUser(getSessionUser(request).getId());
			configImageInfo.setIsDelete("0");
			configImageInfo.setStatus("1");
			result = configService.insertWithImage(configImageInfo,streamVO);
			msg = "保存失败！";
			if(result <= 0){
				return getJsonResult(result, "操作成功",msg);
			}
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isNotBlank(operType)){
				result = configService.updateWithImage(configImageInfo,streamVO);
				if(result <= 0){
					msg = "修改失败！";
					return getJsonResult(result, "操作成功",msg);
				}
			}
		}
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "website_design_content");
		ConfigInfo configInfo = configService.selectEntity(params);
		if (configInfo == null) {
			configInfo = new ConfigInfo();
			configInfo.setId(UUIDUtil.getUUID());
			configInfo.setConfigKey("website_design_content");
			configInfo.setConfigValue(configValue);
			configInfo.setCreateDate(new Date());
			configInfo.setCreateUser(getSessionUser(request).getId());
			configInfo.setIsDelete("0");
			configInfo.setStatus("1");
			result = configService.insert(configInfo);
			msg = "保存失败！";
			
		} else {
			configInfo.setConfigValue(configValue);
			result = configService.update(configInfo);
			msg = "修改失败！";
		}
		
		return getJsonResult(result, "操作成功",msg);
	}
}
