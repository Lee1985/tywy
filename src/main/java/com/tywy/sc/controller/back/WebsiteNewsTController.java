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
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.data.model.WebsiteNewsT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.WebsiteNewsTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteNewsTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-12 00:11:40 
* @Copyright：
 */
@Controller
public class WebsiteNewsTController extends BaseController {
	
	@Resource
	private WebsiteNewsTService websiteNewsTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;

	@RequestMapping(value = "system/websiteNewsTList")
	public String websiteNewsTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "back/website_news_list";
	}

	@RequestMapping(value = "system/websiteNewsTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteNewsT> websiteNewsTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteNewsT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteNewsT> pageInfo = new PageInfo<WebsiteNewsT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		info.setSort("createDate");
		info.setOrder("desc");
		websiteNewsTService.selectAll(info, pageInfo);
		List<WebsiteNewsT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		List<String> categoryIdList = new ArrayList<String>();
		for(WebsiteNewsT entity : list){
			imageUuidList.add(entity.getImgUuid());
			categoryIdList.add(entity.getCatagoryId());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return pageInfo;
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		List<WebsiteCategoryT> categoryList = websiteCategoryTService.selectByIds(categoryIdList);
		if(categoryList == null || categoryList.isEmpty()){
			return pageInfo;
		}
		Map<String,String> categoryMap = new HashMap<String,String>();
		for(WebsiteCategoryT category : categoryList){
			categoryMap.put(category.getId(), category.getName());
		}
		for(WebsiteNewsT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
			entity.setCategoryName(categoryMap.get(entity.getCatagoryId()));
		}
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteNewsTAjaxAll")
	@ResponseBody
	public List<WebsiteNewsT> websiteNewsTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteNewsT info, Integer page,
			Integer rows) {
		List<WebsiteNewsT> results = websiteNewsTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteNewsTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteNewsTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteNewsT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteNewsTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteNewsTService.update(info);
			}else{
				result = websiteNewsTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteNewsTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteNewsTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteNewsT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteNewsTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteNewsTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteNewsTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteNewsT info) {
		int result = 0;
		try {
			result = websiteNewsTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "操作失败！");
	}
}
