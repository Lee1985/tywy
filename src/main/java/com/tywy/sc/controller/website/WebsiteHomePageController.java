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
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCarouselT;
import com.tywy.sc.data.model.WebsiteHomepageBrandT;
import com.tywy.sc.data.model.WebsiteHomepageCaseT;
import com.tywy.sc.data.model.WebsiteNewsT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCarouselTService;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.WebsiteHomepageBrandTService;
import com.tywy.sc.services.WebsiteHomepageCaseTService;
import com.tywy.sc.services.WebsiteNewsTService;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteHomePageController extends BaseController{
	
	@Resource
	private WebsiteCarouselTService websiteHomePageCarouselService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@Resource
	private WebsiteNewsTService websiteNewsTService;
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;
	
	@Resource
	private WebsiteHomepageBrandTService websiteHomepageBrandTService;
	
	@Resource
	private WebsiteHomepageCaseTService websiteHomepageCaseTService;
	
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		
		//轮播图
		PageInfo<WebsiteCarouselT> pageInfo = new PageInfo<WebsiteCarouselT>();
		pageInfo.setPage(1);
		pageInfo.setPageSize(5);
		WebsiteCarouselT info = new WebsiteCarouselT();
		info.setType(1);
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		websiteHomePageCarouselService.selectAll(info, pageInfo);
		List<WebsiteCarouselT> carouselList = pageInfo.getRows();
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteCarouselT websiteCarousel : carouselList){			
			imageUuidList.add(websiteCarousel.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteCarouselT websiteCarousel : carouselList){	
			SystemPictureInfo pic = picMap.get(websiteCarousel.getImgUuid());
			websiteCarousel.setSystemPictureInfo(pic);
		}
		request.setAttribute("carouselList", carouselList);
		
		//品牌
		PageInfo<WebsiteHomepageBrandT> brandPageInfo = new PageInfo<WebsiteHomepageBrandT>();
		brandPageInfo.setPage(1);
		brandPageInfo.setPageSize(5);
		
		WebsiteHomepageBrandT brandInfo = new WebsiteHomepageBrandT();
		brandInfo.setIsDelete("0");
		brandInfo.setSort("orderList");
		brandInfo.setOrder("asc");
		brandInfo.setStatus("1");
		websiteHomepageBrandTService.selectAll(brandInfo, brandPageInfo);
		List<WebsiteHomepageBrandT> brandList = brandPageInfo.getRows();
		
		List<String> brandImageUuidList = new ArrayList<String>();
		for(WebsiteHomepageBrandT entity : brandList){
			brandImageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> brandPicList = systemPictureInfoService.selectByUuids(brandImageUuidList);
		
		Map<String,SystemPictureInfo> brandPicMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : brandPicList){
			brandPicMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteHomepageBrandT entity : brandList){
			SystemPictureInfo pic = brandPicMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("brandList", brandList);
		
		//新闻
		PageInfo<WebsiteNewsT> newsPageInfo = new PageInfo<WebsiteNewsT>();
		newsPageInfo.setPage(1);
		newsPageInfo.setPageSize(2);
		WebsiteNewsT newsInfo = new WebsiteNewsT();
		newsInfo.setIsDelete("0");
		newsInfo.setSort("createDate");
		newsInfo.setOrder("desc");
		websiteNewsTService.selectAll(newsInfo, newsPageInfo);
		List<WebsiteNewsT> newsList = newsPageInfo.getRows();
		if(newsList != null && !newsList.isEmpty()){
			for(WebsiteNewsT news : newsList){
				news.setContent(JsoupUtils.getTextFromTHML(news.getContent()));
			}
		}
		request.setAttribute("newsList", newsList);
		
		return "website/index";
	}
	
	@RequestMapping(value = "websiteHomepageCase")
	@ResponseBody
	public PageInfo<WebsiteHomepageCaseT> websiteHomepageCase(HttpServletRequest request,HttpServletResponse response) {
		PageInfo<WebsiteHomepageCaseT> pageInfo = new PageInfo<WebsiteHomepageCaseT>();
		pageInfo.setPage(1);
		pageInfo.setPageSize(3);
		
		WebsiteHomepageCaseT info = new WebsiteHomepageCaseT();
		info.setIsDelete("0");
		info.setStatus("1");
		info.setSort("orderList");
		info.setOrder("asc");
		
		websiteHomepageCaseTService.selectAll(info, pageInfo);
		List<WebsiteHomepageCaseT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteHomepageCaseT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return pageInfo;
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteHomepageCaseT entity : list){		
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		return pageInfo;
	
	}
}
