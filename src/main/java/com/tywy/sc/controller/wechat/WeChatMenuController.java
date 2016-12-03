package com.tywy.sc.controller.wechat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WeChatCoreService;

/**
 * 
 * @ClassName: WechatMenuController
 * @Description: 菜单控制层
 * @author William
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WeChatMenuController extends BaseController {

	@Resource
	private WeChatCoreService wechatService;

	/**
	 * 跳转网站
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toWechatWebsiteView")
	public String toWechatWebsiteView(HttpServletRequest request, HttpServletResponse response) {
		return "/wechat_official_website";
	}

	/**
	 * 跳转电子相册
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toWechatAlbumView")
	public String toWechatAlbumView(HttpServletRequest request, HttpServletResponse response) {
		return "/wechat_album";
	}

	/**
	 * 跳转联系我们
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toWechatContactView")
	public String toWechatContactView(HttpServletRequest request, HttpServletResponse response) {
		return "/wechat_contact";
	}

}
