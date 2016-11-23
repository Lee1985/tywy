package com.tywy.sc.controller.wechat;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tywy.constant.CfgConstant;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.services.WechatUserInfoTService;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.wechatUtils.FormatXmlProcess;
import com.tywy.utils.wechatUtils.HttpUtil;
import com.tywy.utils.wechatUtils.ReceiveXmlProcess;
import com.tywy.utils.wechatUtils.ReceiveXmlVO;

/**
 * 
 * @ClassName: WeChatController
 * @Description: 公众号接口控制层
 * @author william
 * @date 2016-11-17 16:48:35
 * @Copyright：tywy
 */
@Controller
public class WeChatController extends BaseController {
	@Resource
	private WechatUserInfoTService service;

	public static Logger logger = Logger.getLogger(WechatUserInfoTService.class);
	public static String get_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	public static String get_user_url = "https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN";
	public static String access_token = "";

	/**
	 * 获取用户token
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getToken")
	@ResponseBody
	public String getToken(HttpServletRequest request, HttpServletResponse response) {
		String url = get_token_url + "&appid=" + CfgConstant.APPID + "&secret=" + CfgConstant.APPSECRET;
		try {
			String result = HttpUtil.doGet(url);
			if (StringUtils.contains(result, "errcode")) {
				logger.error("----获取公众号token失败----" + result);
			} else {
				Map<String, String> map = (Map<String, String>) JSON.toJSON(result);
				access_token = map.get("access_token");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return access_token;
	}

	/**
	 * 解析处理xml、获取回复结果
	 * 
	 * @param xml接收到的微信数据
	 * @return 最终的解析结果（xml格式数据）
	 */
	@RequestMapping(value = "/processWechatMsg")
	@ResponseBody
	public String processWechatMsg(HttpServletRequest request, HttpServletResponse response, String xml) {
		/** 解析xml数据 */
		ReceiveXmlVO xmlEntity = new ReceiveXmlProcess().getReceiveXmlVO(xml);

		String result = "";
		if ("text".endsWith(xmlEntity.getMsgType())) {// 文本消息获取回复内容

		} else if ("image".endsWith(xmlEntity.getMsgType())) {// 图片消息获取回复内容

		}
		/**
		 * 此时，如果用户输入的是“你好”，在经过上面的过程之后，result为“你也好”类似的内容
		 * 因为最终回复给微信的也是xml格式的数据，所有需要将其封装为文本类型返回消息
		 */
		result = new FormatXmlProcess().formatTextAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(),
				result);
		return result;
	}

	/**
	 * 获取用户token
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public Object getUserInfo(HttpServletRequest request, HttpServletResponse response, String xml) {
		/** 解析xml数据 */
		ReceiveXmlVO xmlEntity = new ReceiveXmlProcess().getReceiveXmlVO(xml);
		String url = get_user_url + "&access_token=" + access_token + "&openid=" + xmlEntity.getFromUserName();
		int opt = 1;
		String msg = "";
		try {
			String result = HttpUtil.doGet(url);
			if (StringUtils.contains(result, "errcode")) {
				logger.error("----获取用户信息失败----" + result);
			} else {
				WechatUserInfoT user = JSON.parseObject(result, WechatUserInfoT.class);
				Map<String, Object> map = new HashMap<>();
				map.put("openid", user.getOpenid());
				int size = service.selectCount(map);
				if (size > 0) {// 已存在
					opt = service.update(user);
				} else {
					user.setId(UUIDUtil.getUUID());
					opt = service.insert(user);
				}
				if (opt <= 0) {
					msg = "操作失败";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(opt, "操作成功", msg);
	}

}
