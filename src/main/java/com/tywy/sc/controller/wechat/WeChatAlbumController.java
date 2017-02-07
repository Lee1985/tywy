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

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.data.model.WechatAlbumRelT;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.sc.services.WechatAlbumRelTService;
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
	private WechatAlbumListTService listTService;
	@Resource
	private WechatAlbumRelTService relTService;

	/**
	 * 跳转电子相册
	 */
	@RequestMapping(value = "/welcomeIndex")
	public String welcomeIndex(HttpServletRequest request, HttpServletResponse response, Model model) {

		// 获取轮播图
		Map<String, Object> map = new HashMap<>();
		map.put("sort", "orderList");
		map.put("order", "asc");
		map.put("isDelete", "0");
		List<WechatHomepageAlbumT> carousels = albumTService.selectAll(map);
		model.addAttribute("carousels", carousels);

		// 获取专区
		List<WechatElectronicAlbumT> albums = electronicService.selectAll(map);
		model.addAttribute("albums", albums);

		// 当前登陆用户的id
		model.addAttribute("openid", "o_rsSv19Shjb9U71kWm8QmWdfh_E");

		return "wechat/pictures";
	}

	/**
	 * 跳转专区
	 */
	@RequestMapping(value = "/toDiffArea")
	public String toDiffArea(HttpServletRequest request, HttpServletResponse response, Model model, String parentid) {

		Map<String, Object> map = new HashMap<>();
		map.put("parentid", parentid);
		map.put("isDelete", "0");
		List<WechatAlbumListT> albums = listTService.selectAll(map);
		model.addAttribute("albums", albums);

		return "wechat/differentArea";
	}

	/**
	 * 跳转详情
	 */
	@RequestMapping(value = "/toGallery")
	public String toGallery(HttpServletRequest request, HttpServletResponse response, Model model, String id) {

		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> resultMap = new HashMap<>();

		Map<String, Object> map = new HashMap<>();
		map.put("parentid", id);
		List<WechatAlbumRelT> albumList = relTService.selectAll(map);
		if (albumList != null && albumList.size() > 0) {
			for (WechatAlbumRelT wechatAlbumRelT : albumList) {
				resultMap.put("id", wechatAlbumRelT.getId());
				resultMap.put("urlPath", wechatAlbumRelT.getUrlPath());
				resultMap.put("orderList", wechatAlbumRelT.getOrderList());
				resultMap.put("description", wechatAlbumRelT.getDescription());
			}
			resultList.add(resultMap);
		}
		model.addAttribute("albums", resultList);

		return "wechat/gallery";
	}

}
