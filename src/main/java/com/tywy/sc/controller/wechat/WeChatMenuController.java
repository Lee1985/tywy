package com.tywy.sc.controller.wechat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

/**
 * @author Liuheli
 * @ClassName: WechatMenuController
 * @Description: 菜单控制层
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WeChatMenuController extends BaseController {

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
	 * 跳转联系我们
	 */
	@RequestMapping(value = "/toWechatContact")
	public String toWechatContactView(HttpServletRequest request, HttpServletResponse response) {
		return "/wechat/contact";
	}

}
