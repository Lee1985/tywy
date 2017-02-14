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
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCarouselT;
import com.tywy.sc.data.model.WebsiteNewsT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCarouselTService;
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
}
