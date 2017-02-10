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
import com.tywy.sc.data.model.WebsiteHomepageCaseT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteHomepageCaseTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteHomepageCaseTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-10 14:58:24 
* @Copyright：
 */
@Controller
public class WebsiteHomepageCaseTController extends BaseController {
	
	@Resource
	private WebsiteHomepageCaseTService websiteHomepageCaseTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteHomepageCaseTList")
	public String websiteHomepageCaseTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "back/website_homepage_case_list";
	}

	@RequestMapping(value = "system/websiteHomepageCaseTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteHomepageCaseT> websiteHomepageCaseTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageCaseT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteHomepageCaseT> pageInfo = new PageInfo<WebsiteHomepageCaseT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
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
	
	@RequestMapping(value = "system/websiteHomepageCaseTAjaxAll")
	@ResponseBody
	public List<WebsiteHomepageCaseT> websiteHomepageCaseTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageCaseT info, Integer page,
			Integer rows) {
		List<WebsiteHomepageCaseT> results= websiteHomepageCaseTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteHomepageCaseTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteHomepageCaseTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageCaseT info,StreamVO streamVO, String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteHomepageCaseTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteHomepageCaseTService.update(info);
			}else{
				result = websiteHomepageCaseTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteHomepageCaseTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteHomepageCaseTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageCaseT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteHomepageCaseTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteHomepageCaseTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteHomepageCaseTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteHomepageCaseT info) {
		int result = 0;
		try {
			result = websiteHomepageCaseTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
