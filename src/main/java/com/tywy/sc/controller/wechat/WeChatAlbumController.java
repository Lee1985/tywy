package com.tywy.sc.controller.wechat;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
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

	/**
	 * 跳转电子相册
	 */
	@RequestMapping(value = "/welcomeIndex")
	public String welcomeIndex(HttpServletRequest request, HttpServletResponse response, Model model) {

		// 获取轮播图
		WechatHomepageAlbumT albumT = new WechatHomepageAlbumT();
		albumT.setSort("orderList");
		albumT.setOrder("asc");
		albumT.setIsDelete(0);
		List<WechatHomepageAlbumT> albums = albumTService.selectAll(albumT);
		model.addAttribute("albums", albums);

		// 获取专区
		
		return "wechat/pictures";
	}

	/**
	 * 跳转专区
	 */
	@RequestMapping(value = "/toDiffArea")
	public String toDiffArea() {
		return "wechat/differentArea";
	}

	/**
	 * 跳转详情
	 */
	@RequestMapping(value = "/toGallery")
	public String toGallery(HttpServletRequest request, HttpServletResponse response, String id) {
		request.setAttribute("id", id);
		return "wechat/gallery";
	}

	/**
	 * 跳转我的收藏
	 */
	@RequestMapping(value = "/toCollection")
	public String toCollection(HttpServletRequest request, HttpServletResponse response) {
		return "wechat/shoucang";
	}

}
