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
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCaseAlbumT;
import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCaseAlbumTService;
import com.tywy.sc.services.WebsiteCaseTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteCaseController extends BaseController{
	
	@Resource
	private WebsiteCaseAlbumTService websiteCaseAlbumTService;
	
	@Resource
	private WebsiteCaseTService websiteCaseTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@RequestMapping(value = "classicCase")
	public String classicCase(HttpServletRequest request,HttpServletResponse response,String caseId,Integer page) {
		
		Map<String,Object> configParams = new HashMap<String,Object>();
		configParams.put("configKey", "website_case_content");
		ConfigInfo configInfo = configInfoService.selectEntity(configParams);
		configInfo.setConfigValue(JsoupUtils.removeStyle(configInfo.getConfigValue()));
		request.setAttribute("configInfo", configInfo);	
		
		WebsiteCaseT info = new WebsiteCaseT();
		info.setStatus("1");
		info.setIsDelete("0");
		info.setSort("orderList");
		info.setOrder("asc");
		List<WebsiteCaseT> caseList = websiteCaseTService.selectAll(info);
		request.setAttribute("caseList", caseList);
		
		if(StringUtils.isBlank(caseId)){
			caseId = caseList.get(0).getId();
		}
		WebsiteCaseT currentCase = websiteCaseTService.selectById(caseId);		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("uuid", currentCase.getImgUuid());
		SystemPictureInfo systemPictureInfo = systemPictureInfoService.selectEntity(params);
		currentCase.setSystemPictureInfo(systemPictureInfo);
		request.setAttribute("caseInfo", currentCase);
		
		if(page == null || page < 1){
			page = 1;
		}
		
		PageInfo<WebsiteCaseAlbumT> pageInfo = new PageInfo<WebsiteCaseAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(8);
		WebsiteCaseAlbumT caseAlbum = new WebsiteCaseAlbumT();
		caseAlbum.setCaseId(caseId);
		caseAlbum.setIsDelete("0");
		caseAlbum.setStatus("1");
		caseAlbum.setSort("createDate");
		caseAlbum.setOrder("asc");
		websiteCaseAlbumTService.selectAll(caseAlbum, pageInfo);
		
		List<WebsiteCaseAlbumT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			request.setAttribute("caseId", caseId);
			request.setAttribute("page", page);
			return "website/classicCase";
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteCaseAlbumT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			request.setAttribute("caseId", caseId);
			request.setAttribute("page", page);
			return "website/classicCase";
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteCaseAlbumT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			pic.setFileSize(FileTool.convertFileSize(pic.getFsize()));
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("list", list);
		request.setAttribute("caseId", caseId);
		request.setAttribute("page", page);
		request.setAttribute("pages", pageInfo.getPages());
		request.setAttribute("total", pageInfo.getTotal());
		return "website/classicCase";
	}
	
}
