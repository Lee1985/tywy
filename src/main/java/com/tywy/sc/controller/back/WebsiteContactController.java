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
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteDesignTService;
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
public class WebsiteContactController extends BaseController {
	
	@Resource
	private WebsiteDesignTService websiteDesignTService;
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteContactInfo")
	public String websiteDesignTList(HttpServletRequest request,HttpServletResponse response,String id) {	
		
		//导航图片
		String imageValue = configInfoService.getConfigValueByKey("contact_us_nav");
		request.setAttribute("imageValue", imageValue);
		
		//qq
		String qqValue = configInfoService.getConfigValueByKey("contact_us_qq");
		request.setAttribute("qqValue", qqValue);
		
		//电话
		String telValue = configInfoService.getConfigValueByKey("contact_us_tel");
		request.setAttribute("telValue", telValue);
		
		//描述
		String contentValue = configInfoService.getConfigValueByKey("contact_us_content");
		request.setAttribute("contentValue", contentValue);
		
		return "back/website_contact_info";
	}
	
	@RequestMapping(value = "system/websiteContactEdit")
	public String websiteContactEdit(HttpServletRequest request,HttpServletResponse response,String id) {	
		
		//导航图片
		String imageValue = configInfoService.getConfigValueByKey("contact_us_nav");
		request.setAttribute("imageValue", imageValue);
		
		//qq
		String qqValue = configInfoService.getConfigValueByKey("contact_us_qq");
		request.setAttribute("qqValue", qqValue);
		
		//电话
		String telValue = configInfoService.getConfigValueByKey("contact_us_tel");
		request.setAttribute("telValue", telValue);
		
		//描述
		String contentValue = configInfoService.getConfigValueByKey("contact_us_content");
		request.setAttribute("contentValue", contentValue);
		
		return "back/website_contact_edit";
	}
	
	@RequestMapping(value="system/websiteContactAjaxSaveSettings")
	@ResponseBody
	public Map<String,Object> websiteContactAjaxSaveSettings(HttpServletRequest request,
			HttpServletResponse response,StreamVO streamVO,String operType,String qqValue,String telValue,String contentValue){
		int result = 0;
		String msg = "";
		
		//导航图
		Map<String,Object> imageParams = new HashMap<String,Object>();
		imageParams.put("configKey", "contact_us_nav");
		ConfigInfo configImageInfo = configInfoService.selectEntity(imageParams);
		if (configImageInfo == null) {
			configImageInfo = new ConfigInfo();
			configImageInfo.setId(UUIDUtil.getUUID());
			configImageInfo.setConfigKey("contact_us_nav");
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
		
		//qq
		Map<String,Object> qqParams = new HashMap<String,Object>();
		qqParams.put("configKey", "contact_us_qq");
		ConfigInfo qqConfigInfo = configInfoService.selectEntity(qqParams);
		if (qqConfigInfo == null) {
			qqConfigInfo = new ConfigInfo();
			qqConfigInfo.setId(UUIDUtil.getUUID());
			qqConfigInfo.setConfigKey("contact_us_qq");
			qqConfigInfo.setConfigValue(qqValue);
			qqConfigInfo.setCreateDate(new Date());
			qqConfigInfo.setCreateUser(getSessionUser(request).getId());
			qqConfigInfo.setIsDelete("0");
			qqConfigInfo.setStatus("1");
			result = configInfoService.insert(qqConfigInfo);
			msg = "保存失败！";
			
		} else {
			qqConfigInfo.setConfigValue(qqValue);
			result = configInfoService.update(qqConfigInfo);
			msg = "修改失败！";
		}
		
		//电话
		Map<String,Object> telParams = new HashMap<String,Object>();
		telParams.put("configKey", "contact_us_tel");
		ConfigInfo telConfigInfo = configInfoService.selectEntity(telParams);
		if (telConfigInfo == null) {
			telConfigInfo = new ConfigInfo();
			telConfigInfo.setId(UUIDUtil.getUUID());
			telConfigInfo.setConfigKey("contact_us_tel");
			telConfigInfo.setConfigValue(telValue);
			telConfigInfo.setCreateDate(new Date());
			telConfigInfo.setCreateUser(getSessionUser(request).getId());
			telConfigInfo.setIsDelete("0");
			telConfigInfo.setStatus("1");
			result = configInfoService.insert(telConfigInfo);
			msg = "保存失败！";
			
		} else {
			telConfigInfo.setConfigValue(telValue);
			result = configInfoService.update(telConfigInfo);
			msg = "修改失败！";
		}
		
		//描述
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("configKey", "contact_us_content");
		ConfigInfo configInfo = configInfoService.selectEntity(params);
		if (configInfo == null) {
			configInfo = new ConfigInfo();
			configInfo.setId(UUIDUtil.getUUID());
			configInfo.setConfigKey("contact_us_content");
			configInfo.setConfigValue(contentValue);
			configInfo.setCreateDate(new Date());
			configInfo.setCreateUser(getSessionUser(request).getId());
			configInfo.setIsDelete("0");
			configInfo.setStatus("1");
			result = configInfoService.insert(configInfo);
			msg = "保存失败！";
			
		} else {
			configInfo.setConfigValue(contentValue);
			result = configInfoService.update(configInfo);
			msg = "修改失败！";
		}
		
		return getJsonResult(result, "操作成功",msg);
	}
}
