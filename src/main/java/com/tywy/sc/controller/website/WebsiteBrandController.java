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
import com.tywy.sc.data.model.WebsiteBrandAlbumT;
import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteBrandAlbumTService;
import com.tywy.sc.services.WebsiteBrandTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteBrandController extends BaseController{
	
	@Resource
	private WebsiteBrandTService websiteBrandTService;
	
	@Resource
	private WebsiteBrandAlbumTService websiteBrandAlbumTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@RequestMapping(value = "brand")
	public String brand(HttpServletRequest request,HttpServletResponse response,String id) {
		
		//菜单
		WebsiteBrandT brandInfo = new WebsiteBrandT();
		brandInfo.setStatus("1");
		brandInfo.setIsDelete("0");
		brandInfo.setSort("createDate");
		brandInfo.setOrder("asc");
		List<WebsiteBrandT> brandList = websiteBrandTService.selectAll(brandInfo);
		request.setAttribute("brandList", brandList);
		
		if(StringUtils.isBlank(id)){
			id = brandList.get(0).getId();
		}
		//品牌
		WebsiteBrandT brand = websiteBrandTService.selectById(id);
		brand.setContent(JsoupUtils.removeStyle(brand.getContent()));
		request.setAttribute("brand", brand);
		
		//品牌相册
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("brandId", id);
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteBrandAlbumT> list = websiteBrandAlbumTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "website/brand";
		}
		
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteBrandAlbumT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "website/brand";
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteBrandAlbumT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			pic.setFileSize(FileTool.convertFileSize(pic.getFsize()));
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("list", list);
		return "website/brand";
	}
	
}
