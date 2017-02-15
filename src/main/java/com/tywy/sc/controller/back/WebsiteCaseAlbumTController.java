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
import com.tywy.sc.data.model.WebsiteCaseAlbumT;
import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteCaseAlbumTService;
import com.tywy.sc.services.WebsiteCaseTService;
import com.tywy.utils.FileTool;
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

		WebsiteCaseT caseInfo = websiteCaseTService.selectById(caseId);
		request.setAttribute("caseInfo", caseInfo);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("caseId", caseId);
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteCaseAlbumT> list = websiteCaseAlbumTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "back/website_case_album_list";
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteCaseAlbumT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "back/website_case_album_list";
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WebsiteCaseAlbumT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			pic.setFileSize(FileTool.convertFileSize(pic.getFsize()));
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("list", list);	
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
		websiteCaseAlbumTService.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteCaseAlbumTAjaxAll")
	@ResponseBody
	public List<WebsiteCaseAlbumT> websiteCaseAlbumTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseAlbumT info, Integer page,
			Integer rows) {
		List<WebsiteCaseAlbumT> results= websiteCaseAlbumTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteCaseAlbumTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCaseAlbumTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseAlbumT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			info.setUpdateUser(getSessionUser(request).getId());
			result = websiteCaseAlbumTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			info.setUpdateUser(getSessionUser(request).getId());
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteCaseAlbumTService.update(info);
			}else{
				result = websiteCaseAlbumTService.updateWithImage(info,streamVO);
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
			result = websiteCaseAlbumTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
