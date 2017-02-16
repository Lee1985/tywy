package com.tywy.sc.controller.back;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.tywy.sc.data.model.SystemUser;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * @author Liuheli
 * @ClassName: WechatElectronicAlbumTController
 * @Description: 电子相册封面控制层
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WechatElectronicAlbumController extends BaseController {
	
	@Resource
	private WechatElectronicAlbumTService wechatElectronicAlbumTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/wechatElectronicAlbumTList")
	public String wechatElectronicAlbumTList(HttpServletRequest request, HttpServletResponse response) {
		return "back/wechat_electronic_album_list";
	}

	@RequestMapping(value = "system/wechatElectronicAlbumTAjaxPage")
	@ResponseBody
	public PageInfo<WechatElectronicAlbumT> wechatElectronicAlbumTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info, Integer page, Integer rows) {
		info.setIsDelete("0");
		info.setOrder("asc");
		info.setSort("orderList");
		PageInfo<WechatElectronicAlbumT> pageInfo = new PageInfo<WechatElectronicAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		wechatElectronicAlbumTService.selectAll(info, pageInfo);
		
		List<WechatElectronicAlbumT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WechatElectronicAlbumT entity : list){
			imageUuidList.add(entity.getImgUuid());
			entity.setUpdateDateStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getUpdateDate()));
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return pageInfo;
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WechatElectronicAlbumT entity : list){		
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		return pageInfo;
	}

	@RequestMapping(value = "system/wechatElectronicAlbumTAjaxAll")
	@ResponseBody
	public List<WechatElectronicAlbumT> wechatElectronicAlbumTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info, Integer page, Integer rows) {
		List<WechatElectronicAlbumT> results = wechatElectronicAlbumTService.selectAll(info);
		return results;
	}

	@RequestMapping(value = "system/wechatElectronicAlbumTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatElectronicAlbumTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatElectronicAlbumT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			info.setUpdateUser(getSessionUser(request).getId());
			result = wechatElectronicAlbumTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			info.setUpdateUser(getSessionUser(request).getId());
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = wechatElectronicAlbumTService.update(info);
			}else{
				result = wechatElectronicAlbumTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/wechatElectronicAlbumTAjaxDelete")
	@ResponseBody
	public Map<String, Object> wechatElectronicAlbumTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info) {
		int result = 0;
		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}
		try {
			info.setIsDelete("1");
			info.setUpdateDate(new Date());
			info.setUpdateUser(systemUser.getId());
			result = wechatElectronicAlbumTService.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result, "操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/wechatElectronicAlbumTAjaxUpdate")
	@ResponseBody
	public Map<String, Object> wechatElectronicAlbumTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info) {
		int result = 0;
		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}
		try {
			info.setUpdateDate(new Date());
			info.setUpdateUser(systemUser.getId());
			result = wechatElectronicAlbumTService.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result,"操作成功", "操作失败！");
	}	
}
