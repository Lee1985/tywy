package com.tywy.sc.controller.website;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteDesignTService;
import com.tywy.utils.FileTool;

@Controller
public class WebsiteDesignController extends BaseController{
	
	@Resource
	private WebsiteDesignTService websiteDesignTService;
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@RequestMapping(value = "designList")
	public String designList(HttpServletRequest request,HttpServletResponse response) {

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteDesignT> list = websiteDesignTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "back/designList";
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteDesignT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "back/designList";
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
		
		Map<String,Object> configParams = new HashMap<String,Object>();
		configParams.put("configKey", "website_design_content");
		ConfigInfo configInfo = configInfoService.selectEntity(configParams);
		request.setAttribute("configInfo", configInfo);	
		return "website/designList";
	}
	
	@RequestMapping(value = "team")
	public String team(HttpServletRequest request,HttpServletResponse response) {
		return "website/team";
	}
	
}
