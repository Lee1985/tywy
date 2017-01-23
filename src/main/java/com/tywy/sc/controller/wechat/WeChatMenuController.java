package com.tywy.sc.controller.wechat;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WeChatCoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Liuheli
 * @ClassName: WechatMenuController
 * @Description: 菜单控制层
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WeChatMenuController extends BaseController {

	@Resource
	private WeChatCoreService wechatService;

	/**
	 * 跳转网站
	 */
	@RequestMapping(value = "/toWechatWebsite")
	public String toWechatWebsiteView() {
		return "/wechat_official_website";
	}

	/**
	 * 跳转电子相册欢迎页
	 */
	@RequestMapping(value = "/toWechatAlbum")
	public String toWechatAlbum() {
		return "/wechat/index";
	}

	/**
	 * 跳转电子相册
	 */
	@RequestMapping(value = "/welcomeIndex")
	public String welcomeIndex() {
		return "/wechat/pictures";
	}

	/**
	 * 跳转专区
	 */
	@RequestMapping(value = "/toDiffArea")
	public String toDiffArea() {
		return "/wechat/differentArea";
	}

	/**
	 * 跳转详情
	 */
	@RequestMapping(value = "/toGallery")
	public String toGallery(HttpServletRequest request, HttpServletResponse response, String id) {
		request.setAttribute("id", id);
		return "/wechat/gallery";
	}

	/**
	 * 跳转联系我们
	 */
	@RequestMapping(value = "/toWechatContact")
	public String toWechatContactView(HttpServletRequest request, HttpServletResponse response) {
		return "/wechat/contact";
	}

	/**
	 * 跳转我的收藏
	 */
	@RequestMapping(value = "/toCollection")
	public String toCollection(HttpServletRequest request, HttpServletResponse response) {
		return "/wechat/shoucang";
	}

}
