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
import com.tywy.sc.data.model.WebsiteBrandAlbumT;
import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WebsiteBrandAlbumTService;
import com.tywy.sc.services.WebsiteBrandTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteBrandAlbumTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-13 04:39:33 
* @Copyright：
 */
@Controller
public class WebsiteBrandAlbumTController extends BaseController {
	
	@Resource
	private WebsiteBrandAlbumTService websiteBrandAlbumTService;
	
	@Resource
	private WebsiteBrandTService websiteBrandTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/websiteBrandAlbumTList")
	public String websiteBrandAlbumTList(HttpServletRequest request,HttpServletResponse response,String brandId) {
		WebsiteBrandT brand = websiteBrandTService.selectById(brandId);
		request.setAttribute("brand", brand);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("brandId", brandId);
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WebsiteBrandAlbumT> list = websiteBrandAlbumTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "back/website_brand_album_list";
		}
		
		List<String> imageUuidList = new ArrayList<String>();
		for(WebsiteBrandAlbumT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "back/website_brand_album_list";
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
		
		return "back/website_brand_album_list";
	}

	@RequestMapping(value = "system/websiteBrandAlbumTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteBrandAlbumT> websiteBrandAlbumTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandAlbumT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteBrandAlbumT> pageInfo = new PageInfo<WebsiteBrandAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		websiteBrandAlbumTService.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteBrandAlbumTAjaxAll")
	@ResponseBody
	public List<WebsiteBrandAlbumT> websiteBrandAlbumTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandAlbumT info, Integer page,
			Integer rows) {
		List<WebsiteBrandAlbumT> results= websiteBrandAlbumTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteBrandAlbumTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteBrandAlbumTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandAlbumT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			info.setUpdateUser(getSessionUser(request).getId());
			result = websiteBrandAlbumTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			info.setUpdateUser(getSessionUser(request).getId());
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteBrandAlbumTService.update(info);
			}else{
				result = websiteBrandAlbumTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteBrandAlbumTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteBrandAlbumTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandAlbumT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteBrandAlbumTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
