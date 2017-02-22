package com.tywy.sc.controller.website;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCompanyQualificationT;
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCompanyQualificationTService;
import com.tywy.sc.services.WebsiteIntroductionTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteAboutController extends BaseController{
	
	@Resource
	private WebsiteIntroductionTService websiteIntroductionTService;
	
	@Resource
	private WebsiteCompanyQualificationTService websiteCompanyQualificationTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@RequestMapping(value = "companyProfile")
	public String companyProfile(HttpServletRequest request,HttpServletResponse response) {
		return "website/companyProfile";
	}
	
	@RequestMapping(value = "companyQualification")
	public String companyQualification(HttpServletRequest request,HttpServletResponse response,
			WebsiteCompanyQualificationT info, Integer page,Integer rows) {
		
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
}
