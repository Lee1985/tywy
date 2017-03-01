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
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WebsiteDesignMemberT;
import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteDesignMemberTService;
import com.tywy.sc.services.WebsiteDesignTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.JsoupUtils;

@Controller
public class WebsiteDesignController extends BaseController{
	
	@Resource
	private WebsiteDesignTService websiteDesignTService;
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;
	
	@Resource
	private WebsiteDesignMemberTService websiteDesignMemberTService;
	
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
		
		String imageConfigUrl = configInfoService.getConfigValueByKey("website_design_nav");
		request.setAttribute("imageConfigUrl", imageConfigUrl);
		
		return "website/designList";
	}
	
	@RequestMapping(value = "team")
	public String team(HttpServletRequest request,HttpServletResponse response) {
		
		String imageConfigUrl = configInfoService.getConfigValueByKey("website_design_member_nav");
		request.setAttribute("imageConfigUrl", imageConfigUrl);
		
		String configContent = configInfoService.getConfigValueByKey("website_design_member_content");
		request.setAttribute("configContent", JsoupUtils.removeStyle(configContent));
				
		PageInfo<WebsiteDesignMemberT> pageInfo = new PageInfo<WebsiteDesignMemberT>();
		pageInfo.setPage(1);
		pageInfo.setPageSize(7);
		WebsiteDesignMemberT info = new WebsiteDesignMemberT();
		info.setIsDelete("0");
		info.setStatus("1");
		info.setSort("orderList");
		info.setOrder("asc");
		websiteDesignMemberTService.selectAll(info, pageInfo);
		List<WebsiteDesignMemberT> designMemberList = pageInfo.getRows();
		request.setAttribute("designMemberList", designMemberList);
		return "website/team";
	}
	
}
