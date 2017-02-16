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
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.utils.FileTool;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
 * @ClassName: WechatAlbumListTController
 * @Description: 电子相册照片控制层
 * @author Liuheli
 * @date 2017-01-25 10:23:05
 */
@Controller
public class WechatAlbumListController extends BaseController {
	
	@Resource
	private WechatElectronicAlbumTService wechatElectronicAlbumTService;
	
	@Resource
	private WechatAlbumListTService wechatAlbumListTService;
	
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/wechatAlbumListTList")
	public String wechatAlbumListTList(HttpServletRequest request, HttpServletResponse response, String albumId) {
		request.setAttribute("albumId", albumId);
		return "back/wechat_album_list";
	}

	@RequestMapping(value = "system/wechatAlbumListTAjaxPage")
	@ResponseBody
	public PageInfo<WechatAlbumListT> wechatAlbumListTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info, Integer page, Integer rows) {
		PageInfo<WechatAlbumListT> pageInfo = new PageInfo<WechatAlbumListT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		wechatAlbumListTService.selectAll(info, pageInfo);
		List<WechatAlbumListT> list = pageInfo.getRows();
		if(list == null || list.isEmpty()){
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WechatAlbumListT entity : list){
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
		for(WechatAlbumListT entity : list){		
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		return pageInfo;
	}
	
	@RequestMapping(value = "system/wechatAlbumListCollection")
	public String wechatAlbumListCollection(HttpServletRequest request,HttpServletResponse response,String albumId) {
		
		WechatElectronicAlbumT wechatElectronicAlbum = wechatElectronicAlbumTService.selectById(albumId);
		request.setAttribute("wechatElectronicAlbum", wechatElectronicAlbum);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("parentid", albumId);
		params.put("isDelete", "0");
		params.put("sort", "createDate");
		params.put("order", "asc");
		List<WechatAlbumListT> list = wechatAlbumListTService.selectAll(params);
		if(list == null || list.isEmpty()){
			return "back/wechat_album_list_collection";
		}
		List<String> imageUuidList = new ArrayList<String>();
		for(WechatAlbumListT entity : list){
			imageUuidList.add(entity.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if(picList == null || picList.isEmpty()){
			return "back/wechat_album_list_collection";
		}
		Map<String,SystemPictureInfo> picMap = new HashMap<String,SystemPictureInfo>();
		for(SystemPictureInfo pictureInfo : picList){
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for(WechatAlbumListT entity : list){
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			pic.setFileSize(FileTool.convertFileSize(pic.getFsize()));
			entity.setSystemPictureInfo(pic);
		}
		request.setAttribute("list", list);	
		return "back/wechat_album_list_collection";
	}

	@RequestMapping(value = "system/wechatAlbumListTAjaxAll")
	@ResponseBody
	public List<WechatAlbumListT> wechatAlbumListTAjaxAll(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info, Integer page, Integer rows) {
		List<WechatAlbumListT> results = wechatAlbumListTService.selectAll(info);
		return results;
	}

	@RequestMapping(value = "system/wechatAlbumListTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatAlbumListTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			info.setUpdateUser(getSessionUser(request).getId());
			result = wechatAlbumListTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			info.setUpdateUser(getSessionUser(request).getId());
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = wechatAlbumListTService.update(info);
			}else{
				result = wechatAlbumListTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/wechatAlbumListTAjaxDelete")
	@ResponseBody
	public Map<String, Object> wechatAlbumListTAjaxDelete(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info) {
		int result = 0;

		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}
		try {
			info.setIsDelete("1");
			info.setUpdateDate(new Date());
			info.setUpdateUser(systemUser.getId());
			result = wechatAlbumListTService.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getJsonResult(result, "操作成功", "删除失败！");
	}
}
