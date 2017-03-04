package com.tywy.sc.controller.wechat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.ConfigInfoService;

/**
 * @author Liuheli
 * @ClassName: WechatMenuController
 * @Description: 菜单控制层
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WeChatMenuController extends BaseController {

	@Resource
	private ConfigInfoService configInfoService;

	/**
	 * 跳转网站
	 */
	@RequestMapping(value = "/toWechatWebsite")
	public String toWechatWebsiteView() {
		return "wechat_official_website";
	}

	/**
	 * 跳转电子相册欢迎页
	 */
	@RequestMapping(value = "/toWechatAlbum")
	public String toWechatAlbum() {
		return "wechat/index";
	}

	/**
	 * 跳转联系我们
	 */
	@RequestMapping(value = "/toWechatContact")
	public String toWechatContactView(HttpServletRequest request, HttpServletResponse response) {

		// 公司名称
		String companyValue = configInfoService.getConfigValueByKey("contact_us_wechat_company");
		request.setAttribute("companyValue", companyValue);

		// 公司地址
		String addressValue = configInfoService.getConfigValueByKey("contact_us_wechat_address");
		request.setAttribute("addressValue", addressValue);

		// 公司网址
		String websiteValue = configInfoService.getConfigValueByKey("contact_us_wechat_website");
		request.setAttribute("websiteValue", websiteValue);

		// 描述
		String contentValue = configInfoService.getConfigValueByKey("contact_us_wechat_content");
		request.setAttribute("contentValue", contentValue);

		return "wechat/contact";
	}

}
