package com.tywy.sc.controller.back;

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
import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatHomepageAlbumTService;
import com.tywy.utils.DateUtils;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
 * @ClassName: WechatHomepageAlbumTController
 * @Description: 微信电子相册轮播图控制层
 * @author Liuheli
 * @date 2017-01-23 17:12:42
 */
@Controller
public class WechatHomepageAlbumTController extends BaseController {
	@Resource
	private WechatHomepageAlbumTService service;
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "system/wechatHomepageAlbumTList")
	public String wechatHomepageAlbumTList(HttpServletRequest request, HttpServletResponse response) {
		return "back/wechat_homepage_album_t_list";
	}

	@RequestMapping(value = "system/wechatHomepageAlbumTAjaxPage")
	@ResponseBody
	public PageInfo<WechatHomepageAlbumT> wechatHomepageAlbumTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WechatHomepageAlbumT info, Integer page, Integer rows) {
		PageInfo<WechatHomepageAlbumT> pageInfo = new PageInfo<WechatHomepageAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		service.selectAll(info, pageInfo);
		List<WechatHomepageAlbumT> carouselList = pageInfo.getRows();
		if (carouselList == null || carouselList.isEmpty()) {
			return pageInfo;
		}
		List<String> imageUuidList = new ArrayList<String>();
		for (WechatHomepageAlbumT weChatCarousel : carouselList) {
			imageUuidList.add(weChatCarousel.getImgUuid());
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if (picList == null || picList.isEmpty()) {
			return pageInfo;
		}
		Map<String, SystemPictureInfo> picMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : picList) {
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for (WechatHomepageAlbumT weChatCarousel : carouselList) {
			SystemPictureInfo pic = picMap.get(weChatCarousel.getImgUuid());
			weChatCarousel.setSystemPictureInfo(pic);
		}
		pageInfo.setRows(carouselList);
		return pageInfo;
	}

	@RequestMapping(value = "system/wechatHomepageAlbumTAjaxAll")
	@ResponseBody
	public List<WechatHomepageAlbumT> wechatHomepageAlbumTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WechatHomepageAlbumT info, Integer page, Integer rows) {
		List<WechatHomepageAlbumT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "system/wechatHomepageAlbumTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatHomepageAlbumTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatHomepageAlbumT info, StreamVO streamVO, String operType) {
		int result = 0;
		String msg = "";
		info.setIsDelete(0);
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = service.insertWithImage(info, streamVO);
			msg = "保存失败！";
		} else {
			// 根据opertyp判断是否需要上传
			if (StringUtils.isBlank(operType)) {
				result = service.update(info);
			} else {
				result = service.updateWithImage(info, streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功", msg);

	}

	@RequestMapping(value = "system/wechatHomepageAlbumTAjaxDelete")
	@ResponseBody
	public Map<String, Object> wechatHomepageAlbumTAjaxDelete(HttpServletRequest request, HttpServletResponse response,
			WechatHomepageAlbumT info) {
		int result = 0;

		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}

		try {
			WechatHomepageAlbumT uinfo = new WechatHomepageAlbumT();
			uinfo.setId(info.getId());
			uinfo.setIsDelete(1);
			uinfo.setUpdateDate(DateUtils.getDateTimeFormat(new Date()));
			uinfo.setUpdateUser(systemUser.getId());
			result = service.update(uinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result, "操作成功", "删除失败！");
	}

	@RequestMapping(value = "system/wechatHomepageCarouselAjaxUpdate")
	@ResponseBody
	public Map<String, Object> wechatHomepageCarouselAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WechatHomepageAlbumT info) {
		int result = 0;
		try {
			result = service.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getJsonResult(result, "操作成功", "删除失败！");
	}
}
