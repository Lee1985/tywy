package com.tywy.sc.controller.wechat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * 搜索图片-初始回复
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toWechatSearch")
	@ResponseBody
	public void toWechatSearch(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			// 调用核心业务类接收消息、处理消息
			String respMessage = wechatService.searchRequest(request);
			// 响应消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 联系人-初始回复
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toWechatContact")
	@ResponseBody
	public void toWechatContact(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			// 调用核心业务类接收消息、处理消息
			String respMessage = wechatService.contactRequest(request);
			// 响应消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
