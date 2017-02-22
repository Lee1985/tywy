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
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.data.model.WebsiteNewsT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.WebsiteNewsTService;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteNewsController extends BaseController{
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;
	
	@Resource
	private WebsiteNewsTService websiteNewsTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@RequestMapping(value = "news")
	public String news(HttpServletRequest request,HttpServletResponse response,String categoryId) {
				
		//新闻类型
		WebsiteCategoryT info = new WebsiteCategoryT();
		info.setStatus(1);
		info.setCode("news");
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		List<WebsiteCategoryT> categoryList = websiteCategoryTService.selectAll(info);
		request.setAttribute("categoryList", categoryList);
		
		if(StringUtils.isBlank(categoryId)){
			categoryId = categoryList.get(0).getId();
		}
		
		WebsiteCategoryT categoryInfo = websiteCategoryTService.selectById(categoryId);
		Map<String,Object> picParams = new HashMap<String,Object>();
		picParams.put("uuid", categoryInfo.getImgUuid());
		SystemPictureInfo systemPictureInfo = systemPictureInfoService.selectEntity(picParams);
		categoryInfo.setSystemPictureInfo(systemPictureInfo);
		request.setAttribute("categoryInfo", categoryInfo);
		
		//新闻列表
		WebsiteNewsT newsInfo = new WebsiteNewsT();
		newsInfo.setIsDelete("0");
		newsInfo.setStatus(1);
		newsInfo.setCatagoryId(categoryId);
		newsInfo.setSort("createDate");
		newsInfo.setOrder("desc");
		List<WebsiteNewsT> newsList = websiteNewsTService.selectAll(newsInfo);
		if(newsList != null && !newsList.isEmpty()){
			List<String> imageUuidList = new ArrayList<String>();
			for(WebsiteNewsT entity : newsList){
				imageUuidList.add(entity.getImgUuid());
			}
			List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
			Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
			for(SystemPictureInfo pictureInfo : picList){
				picMap.put(pictureInfo.getUuid(), pictureInfo);
			}
			for(WebsiteNewsT entity : newsList){
				SystemPictureInfo pic = picMap.get(entity.getImgUuid());
				entity.setSystemPictureInfo(pic);
				entity.setContent(JsoupUtils.getTextFromTHML(entity.getContent()));
			}			
		}
		request.setAttribute("newsList", newsList);
		request.setAttribute("categoryId", categoryId);
				
		return "website/news";
	}
	
	@RequestMapping(value = "newsDetail")
	public String newsDetail(HttpServletRequest request,HttpServletResponse response,String id) {
		
		//新闻类型
		WebsiteCategoryT info = new WebsiteCategoryT();
		info.setStatus(1);
		info.setCode("news");
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		List<WebsiteCategoryT> categoryList = websiteCategoryTService.selectAll(info);
		request.setAttribute("categoryList", categoryList);
		
		WebsiteNewsT newsinfo = websiteNewsTService.selectById(id);
		newsinfo.setContent(JsoupUtils.removeStyle(newsinfo.getContent()));
		request.setAttribute("newsInfo", newsinfo);
		
		request.setAttribute("categoryId", newsinfo.getCatagoryId());
		return "website/newsDetail";
	}
	
}
