package com.tywy.sc.controller.website;

import java.text.SimpleDateFormat;
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
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCompanyQualificationT;
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.sc.data.model.WebsiteMessageT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCompanyQualificationTService;
import com.tywy.sc.services.WebsiteIntroductionTService;
import com.tywy.sc.services.WebsiteMessageTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.JsoupUtils;
import com.tywy.utils.UUIDUtil;

@Controller
public class WebsiteAboutController extends BaseController{
	
	@Resource
	private WebsiteIntroductionTService websiteIntroductionTService;
	
	@Resource
	private WebsiteCompanyQualificationTService websiteCompanyQualificationTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@Resource
	private WebsiteMessageTService websiteMessageTService;
	
	@RequestMapping(value = "companyProfile")
	public String companyProfile(HttpServletRequest request,HttpServletResponse response) {
		return "website/companyProfile";
	}
	
	@RequestMapping(value = "companyQualification")
	public String companyQualification(HttpServletRequest request,HttpServletResponse response,
			WebsiteCompanyQualificationT info, Integer page,Integer rows) {
		
		String configValue = configInfoService.getConfigValueByKey("website_company_qualification_nav");
		request.setAttribute("configValue", configValue);
		
		Map<String,Object> introParams = new HashMap<String,Object>();
		introParams.put("status", "1");
		introParams.put("isDelete", "0");
		List<WebsiteIntroductionT> introList = websiteIntroductionTService.selectAll(introParams);
		request.setAttribute("introductionList", introList);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteCompanyQualificationT> list = websiteCompanyQualificationTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "website/companyQualification";
		}
		
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteCompanyQualificationT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "website/companyQualification";
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
		
		return "website/companyQualification";
	}
	
	@RequestMapping(value = "contact")
	public String contact(HttpServletRequest request,HttpServletResponse response) {
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
		request.setAttribute("contentValue", JsoupUtils.removeStyle(contentValue));
		
		return "website/contact";
	}
	
	@RequestMapping(value = "aboutContent")
	public String aboutContent(HttpServletRequest request,HttpServletResponse response,String id) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", "1");
		params.put("isDelete", "0");
		List<WebsiteIntroductionT> list = websiteIntroductionTService.selectAll(params);
		request.setAttribute("introductionList", list);
		if(StringUtils.isBlank(id)){
			id = list.get(0).getId();
		}
		WebsiteIntroductionT info = websiteIntroductionTService.selectById(id);
		Map<String,Object> picParams = new HashMap<String,Object>();
		picParams.put("uuid", info.getImgUuid());
		SystemPictureInfo systemPictureInfo = systemPictureInfoService.selectEntity(picParams);
		info.setSystemPictureInfo(systemPictureInfo);		
		info.setDescription(JsoupUtils.removeStyle(info.getDescription()));
		request.setAttribute("introduction", info);
		return "website/companyProfile";
	}
	
	@RequestMapping(value = "contactSubmit")
	@ResponseBody
	public Map<String,Object> contactSubmit(HttpServletRequest request,
			HttpServletResponse response, WebsiteMessageT info) {
		int result = 0;
		try {
			info.setId(UUIDUtil.getUUID());
			info.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			result = websiteMessageTService.insert(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result,"操作成功", "操作失败！");
	}
}
