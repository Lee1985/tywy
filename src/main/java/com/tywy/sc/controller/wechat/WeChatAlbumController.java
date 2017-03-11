package com.tywy.sc.controller.wechat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.sc.services.WechatHomepageAlbumTService;

/**
 * @author Liuheli
 * @ClassName: WechatMenuController
 * @Description: 微信电子控制层
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WeChatAlbumController extends BaseController {

	@Resource
	private WechatHomepageAlbumTService albumTService;
	@Resource
	private WechatElectronicAlbumTService electronicService;
	@Resource
	private WechatAlbumListTService albumListService;
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	/**
	 * 跳转电子相册
	 */
	@RequestMapping(value = "/welcomeIndex")
	public String welcomeIndex(HttpServletRequest request, HttpServletResponse response, Model model, String userid) {

		// 当前登陆用户的id
		model.addAttribute("userid", userid);

		// 获取轮播图
		Map<String, Object> map = new HashMap<>();
		map.put("sort", "orderList");
		map.put("order", "asc");
		map.put("isDelete", "0");
		List<WechatHomepageAlbumT> carousels = albumTService.selectAll(map);

		List<String> imgUuidList = new ArrayList<String>();
		for (WechatHomepageAlbumT entity : carousels) {
			imgUuidList.add(entity.getImgUuid());
		}
		if (imgUuidList == null || imgUuidList.isEmpty()) {
			model.addAttribute("carousels", carousels);
			List<WechatElectronicAlbumT> list = new ArrayList<>();
			model.addAttribute("albums", list);
			return "wechat/pictures";
		}
		List<SystemPictureInfo> carouselList = systemPictureInfoService.selectByUuids(imgUuidList);
		Map<String, SystemPictureInfo> carouselMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : carouselList) {
			carouselMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for (WechatHomepageAlbumT entity : carousels) {
			SystemPictureInfo pic = carouselMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		model.addAttribute("carousels", carousels);
		
		// 获取专区
		map.put("status", "1");
		List<WechatElectronicAlbumT> albums = electronicService.selectAll(map);

		List<String> imageUuidList = new ArrayList<String>();
		for (WechatElectronicAlbumT entity : albums) {
			imageUuidList.add(entity.getImgUuid());
		}
		if (imageUuidList == null || imageUuidList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/pictures";
		}

		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if (picList == null || picList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/pictures";
		}
		Map<String, SystemPictureInfo> picMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : picList) {
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for (WechatElectronicAlbumT entity : albums) {
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}

		model.addAttribute("albums", albums);
		return "wechat/pictures";
	}

	/**
	 * ajax查询专区图集
	 * 
	 * @param request
	 * @param response
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/queryDiffAreAjax", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject queryDiffAreAjax(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info) {

		JSONObject jsonObject = new JSONObject();

		if (info.getPage() == null) {
			info.setPage(1);
		}
		if (info.getPageSize() == null) {
			info.setPageSize(15);
		}

		info.setSort("updateDate");// 按照时间降序排列

		PageInfo<WechatAlbumListT> pageInfo = new PageInfo<WechatAlbumListT>();
		pageInfo.setPage(info.getPage());
		pageInfo.setPageSize(info.getPageSize());
		PageInfo<WechatAlbumListT> pageList = albumListService.selectAll(info, pageInfo);

		jsonObject.put("total", pageList.getTotal());

		List<String> imageUuidList = new ArrayList<String>();
		List<WechatAlbumListT> albums = pageList.getRows();
		for (WechatAlbumListT entity : albums) {
			imageUuidList.add(entity.getImgUuid());
		}
		if (imageUuidList == null || imageUuidList.isEmpty()) {
			jsonObject.put("albums", JSONArray.toJSON(albums));
			jsonObject.put("currtotal", albums.size());
			return jsonObject;
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if (picList == null || picList.isEmpty()) {
			jsonObject.put("albums", JSONArray.toJSON(albums));
			jsonObject.put("currtotal", albums.size());
			return jsonObject;
		}
		Map<String, SystemPictureInfo> picMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : picList) {
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for (WechatAlbumListT entity : albums) {
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}

		jsonObject.put("albums", JSONArray.toJSON(albums));
		jsonObject.put("currtotal", albums.size());
		return jsonObject;
	}

	/**
	 * 跳转专区
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param parentid
	 * @return
	 */
	@RequestMapping(value = "/toDiffArea")
	public String toDiffArea(HttpServletRequest request, HttpServletResponse response, Model model,
			WechatAlbumListT info) {

		model.addAttribute("userid", info.getUserid());
		model.addAttribute("parentid", info.getParentid());

		WechatElectronicAlbumT wechatElectronicAlbumT = electronicService.selectById(info.getParentid());
		model.addAttribute("title", wechatElectronicAlbumT.getAlbumName());

		if (info.getPage() == null) {
			info.setPage(1);
		}
		if (info.getPageSize() == null) {
			info.setPageSize(15);
		}

		info.setSort("updateDate");// 按照时间降序排列
		info.setIsDelete("0");
		PageInfo<WechatAlbumListT> pageInfo = new PageInfo<WechatAlbumListT>();
		pageInfo.setPage(info.getPage());
		pageInfo.setPageSize(info.getPageSize());
		PageInfo<WechatAlbumListT> pageList = albumListService.selectAll(info, pageInfo);

		model.addAttribute("total", pageList.getTotal());

		List<String> imageUuidList = new ArrayList<String>();
		List<WechatAlbumListT> albums = pageList.getRows();

		model.addAttribute("currtotal", albums.size());

		for (WechatAlbumListT entity : albums) {
			imageUuidList.add(entity.getImgUuid());
		}
		if (imageUuidList == null || imageUuidList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/differentArea";
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if (picList == null || picList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/differentArea";
		}
		Map<String, SystemPictureInfo> picMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : picList) {
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for (WechatAlbumListT entity : albums) {
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}

		model.addAttribute("albums", albums);
		return "wechat/differentArea";
	}

	/**
	 * 跳转详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param parentid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/toGallery")
	public String toGallery(HttpServletRequest request, HttpServletResponse response, Model model, String parentid,
			String userid) {

		model.addAttribute("userid", userid);

		WechatElectronicAlbumT wechatElectronicAlbumT = electronicService.selectById(parentid);
		model.addAttribute("title", wechatElectronicAlbumT.getAlbumName());

		// WechatAlbumListT info = new WechatAlbumListT();
		// info.setParentid(parentid);
		// info.setIsDelete("0");
		// info.setSort("updateDate");
		// info.setOrder("desc");
		// PageInfo<WechatAlbumListT> pageInfo = new
		// PageInfo<WechatAlbumListT>();
		// pageInfo.setPage(page);
		// pageInfo.setPageSize(1);
		// albumListService.selectAll(info, pageInfo);

		Map<String, Object> map = new HashMap<>();
		map.put("parentid", parentid);
		map.put("isDelete", "0");
		map.put("sort", "updateDate");
		map.put("order", "desc");
		List<WechatAlbumListT> albums = albumListService.selectAll(map);
		List<String> imageUuidList = new ArrayList<String>();
		for (WechatAlbumListT entity : albums) {
			imageUuidList.add(entity.getImgUuid());
		}
		if (imageUuidList == null || imageUuidList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/gallery";
		}
		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if (picList == null || picList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/gallery";
		}
		Map<String, SystemPictureInfo> picMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : picList) {
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		for (WechatAlbumListT entity : albums) {
			SystemPictureInfo pic = picMap.get(entity.getImgUuid());
			entity.setSystemPictureInfo(pic);
		}
		//
		// model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("albums", albums);
		return "wechat/gallery";
	}

	/**
	 * 跳转详情
	 */
	@RequestMapping(value = "/toCollectionDetail")
	public String toCollectionDetail(HttpServletRequest request, HttpServletResponse response, Model model, String id,
			String userid) {

		model.addAttribute("title", "收藏详情");
		model.addAttribute("userid", userid);

		WechatAlbumListT albums = albumListService.selectById(id);

		List<String> imageUuidList = new ArrayList<String>();
		imageUuidList.add(albums.getImgUuid());

		if (imageUuidList == null || imageUuidList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/collectDetail";
		}

		List<SystemPictureInfo> picList = systemPictureInfoService.selectByUuids(imageUuidList);
		if (picList == null || picList.isEmpty()) {
			model.addAttribute("albums", albums);
			return "wechat/collectDetail";
		}
		Map<String, SystemPictureInfo> picMap = new HashMap<String, SystemPictureInfo>();
		for (SystemPictureInfo pictureInfo : picList) {
			picMap.put(pictureInfo.getUuid(), pictureInfo);
		}
		SystemPictureInfo pic = picMap.get(albums.getImgUuid());
		albums.setSystemPictureInfo(pic);

		model.addAttribute("albums", albums);
		return "wechat/collectDetail";
	}

}
