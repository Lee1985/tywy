package com.tywy.sc.controller.back;

import java.util.Date;
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
import com.tywy.sc.data.model.WebsiteCaseAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCaseAlbumTService;
import com.tywy.sc.services.WebsiteCaseTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteCaseAlbumTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-16 03:29:32 
* @Copyright：
 */
@Controller
public class WebsiteCaseAlbumTController extends BaseController {
	
	@Resource
	private WebsiteCaseAlbumTService websiteCaseAlbumTService;
	
	@Resource
	private WebsiteCaseTService websiteCaseTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteCaseAlbumTList")
	public String websiteCaseAlbumTList(HttpServletRequest request,HttpServletResponse response,String caseId) {
		request.setAttribute("caseId", caseId);
		return "back/website_case_album_list";
	}
	
	@RequestMapping(value = "system/websiteCaseAlbumTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteCaseAlbumT> websiteCaseAlbumTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseAlbumT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteCaseAlbumT> pageInfo = new PageInfo<WebsiteCaseAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		info.setSort("updateDate");
		info.setOrder("desc");
		websiteCaseAlbumTService.selectAll(info, pageInfo);
		return pageInfo;
	}
	
	@RequestMapping(value = "system/websiteCaseAlbumTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCaseAlbumTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseAlbumT info,StreamVO streamVO,String operType,String iconOperType) {
		
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			Map<String,Object> iconMap = streamVO.getMap();
			iconMap.put("prefix", "icon");
			info.setCreateUser(getSessionUser(request).getId());
			info.setUpdateUser(getSessionUser(request).getId());
			result = websiteCaseAlbumTService.insertWithImage(info,streamVO,iconMap);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				if(StringUtils.isBlank(iconOperType)){
					result = websiteCaseAlbumTService.update(info);
				}else{
					Map<String,Object> iconMap = streamVO.getMap();
					iconMap.put("prefix", "icon");
					result = websiteCaseAlbumTService.updateWithImage(info,null,iconMap);
				}				
			}else{
				if(StringUtils.isBlank(iconOperType)){
					result = websiteCaseAlbumTService.updateWithImage(info,streamVO,null);
				}else{
					Map<String,Object> iconMap = streamVO.getMap();
					iconMap.put("prefix", "icon");
					result = websiteCaseAlbumTService.updateWithImage(info,streamVO,iconMap);
				}
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteCaseAlbumTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteCaseAlbumTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseAlbumT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			info.setUpdateDate(new Date());
			result = websiteCaseAlbumTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteCaseAlbumTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteCaseAlbumTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseAlbumT info) {
		int result = 0;
		try {
			info.setUpdateDate(new Date());
			result = websiteCaseAlbumTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
