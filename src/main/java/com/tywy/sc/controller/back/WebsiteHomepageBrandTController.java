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
import com.tywy.sc.data.model.WebsiteHomepageBrandT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteHomepageBrandTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteHomepageBrandTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-08 11:27:22 
* @Copyright：
 */
@Controller
public class WebsiteHomepageBrandTController extends BaseController {
	
	@Resource
	private WebsiteHomepageBrandTService websiteHomepageBrandTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteHomepageBrandTList")
	public String websiteHomepageBrandTList(HttpServletRequest request,HttpServletResponse response) {
		return "back/website_homepage_brand_list";
	}
	
	@RequestMapping(value = "system/websiteHomepageBrandTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteHomepageBrandT> websiteHomepageBrandTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteHomepageBrandT> pageInfo = new PageInfo<WebsiteHomepageBrandT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		info.setSort("orderList");
		info.setOrder("asc");
		websiteHomepageBrandTService.selectAll(info, pageInfo);
		List<WebsiteHomepageBrandT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteHomepageBrandT entity : list){
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
		for(WebsiteHomepageBrandT entity : list){		
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteHomepageBrandTAjaxAll")
	@ResponseBody
	public List<WebsiteHomepageBrandT> websiteHomepageBrandTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info, Integer page,
			Integer rows) {
		List<WebsiteHomepageBrandT> results= websiteHomepageBrandTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteHomepageBrandTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteHomepageBrandTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info,StreamVO streamVO,String operType,String iconOperType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			Map<String,Object> iconMap = streamVO.getMap();
			iconMap.put("prefix", "icon");
			info.setCreateUser(getSessionUser(request).getId());
			info.setUpdateUser(getSessionUser(request).getId());
			result = websiteHomepageBrandTService.insertWithImage(info,streamVO,iconMap);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				if(StringUtils.isBlank(iconOperType)){
					result = websiteHomepageBrandTService.update(info);
				}else{
					Map<String,Object> iconMap = streamVO.getMap();
					iconMap.put("prefix", "icon");
					result = websiteHomepageBrandTService.updateWithImage(info,null,iconMap);
				}				
			}else{
				if(StringUtils.isBlank(iconOperType)){
					result = websiteHomepageBrandTService.updateWithImage(info,streamVO,null);
				}else{
					Map<String,Object> iconMap = streamVO.getMap();
					iconMap.put("prefix", "icon");
					result = websiteHomepageBrandTService.updateWithImage(info,streamVO,iconMap);
				}
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteHomepageBrandTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteHomepageBrandTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteHomepageBrandTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteHomepageBrandTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteCarouselTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageBrandT info) {
		int result = 0;
		try {
			result = websiteHomepageBrandTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
