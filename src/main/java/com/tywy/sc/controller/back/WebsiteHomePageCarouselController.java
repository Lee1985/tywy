package com.tywy.sc.controller.back;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteCarouselT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCarouselTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteHomePageCarouselController 
* @Description: 网站首页轮播图控制层 
* @author lipeng 
* @date 2017-01-18 00:44:40 
* @Copyright：
 */
@Controller
public class WebsiteHomePageCarouselController extends BaseController {
	
	@Resource
	private WebsiteCarouselTService websiteHomePageCarouselService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteHomePageCarouselList")
	public String websiteCarouselTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "back/website_homepage_carousel_list";
	}

	@RequestMapping(value = "system/websiteHomePageCarouselAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteCarouselT> websiteCarouselTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteCarouselT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteCarouselT> pageInfo = new PageInfo<WebsiteCarouselT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setType(1);
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		websiteHomePageCarouselService.selectAll(info, pageInfo);
		List<WebsiteCarouselT> carouselList = pageInfo.getRows();
		if(carouselList == null || carouselList.isEmpty()){
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteCarouselT websiteCarousel : carouselList){			
			imageUuidList.add(websiteCarousel.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return pageInfo;
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteCarouselT websiteCarousel : carouselList){			
			SystemPictureInfo pic = picMap.get(websiteCarousel.getImgUuid());
			websiteCarousel.setSystemPictureInfo(pic);
		}
		pageInfo.setRows(carouselList);
		return pageInfo;
	}

	@RequestMapping(value = "/websiteCarouselTAjaxAll")
	@ResponseBody
	public List<WebsiteCarouselT> websiteCarouselTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteCarouselT info, Integer page,
			Integer rows) {
		List<WebsiteCarouselT> results= websiteHomePageCarouselService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteHomePageCarouselAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCarouselTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCarouselT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteHomePageCarouselService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteHomePageCarouselService.update(info);
			}else{
				result = websiteHomePageCarouselService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteHomePageCarouselAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteCarouselTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteCarouselT info) {
		int result = 0;
		try {
			info.setIsDelete(1);
			result = websiteHomePageCarouselService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteHomePageCarouselAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteCarouselTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteCarouselT info) {
		int result = 0;
		try {
			result = websiteHomePageCarouselService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}	
}
