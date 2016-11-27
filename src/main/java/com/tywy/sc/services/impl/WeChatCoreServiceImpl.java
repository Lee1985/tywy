package com.tywy.sc.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tywy.constant.CfgConstant;
import com.tywy.constant.MessageConstanct;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.data.model.WechatPubReplyT;
import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.data.model.wechat.ReceiveXmlVO;
import com.tywy.sc.services.WeChatCoreService;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.sc.services.WechatPubReplyTService;
import com.tywy.sc.services.WechatUserInfoTService;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.wechat.FormatXmlUtil;
import com.tywy.utils.wechat.HttpUtil;
import com.tywy.utils.wechat.ReceiveXmlUtil;

@Service
public class WeChatCoreServiceImpl extends BaseServiceImpl<ReceiveXmlVO> implements WeChatCoreService {

	@Autowired
	private WechatUserInfoTService wechatuserService;
	@Autowired
	private WechatPubReplyTService replyService;
	@Autowired
	private WechatAlbumListTService albumService;

	/**
	 * 处理微信请求信息
	 */
	@Override
	public String processRequest(HttpServletRequest request) throws Exception {
		String respMessage = null;

		// 调用消息工具类ReceiveXmlUtil解析微信发来的xml格式的消息
		String xml = ReceiveXmlUtil.parseXml(request);
		System.out.println("xml is:" + xml);

		// 反射处理XML字符串型消息
		ReceiveXmlVO xmlEntity = new ReceiveXmlVO();
		xmlEntity = ReceiveXmlUtil.getReceiveXmlVO(xml, xmlEntity.getClass().getName());
		if (xmlEntity != null) {
			switch (xmlEntity.getMsgType()) {
			case MessageConstanct.REQ_MESSAGE_TYPE_TEXT:// 文本
				respMessage = this.todoTextTask(xmlEntity);
				break;
			case MessageConstanct.REQ_MESSAGE_TYPE_EVENT:// 推送
				respMessage = this.todoEventTask(xmlEntity);
				break;
			}
		}
		return respMessage;
	}

	/**
	 * 推送事件
	 * 
	 * @param xmlEntity
	 * @return
	 */
	private String todoEventTask(ReceiveXmlVO xmlEntity) {
		String respMessage = null;
		String content = null;
		String openid = xmlEntity.getFromUserName();

		// 获取服务器用户的信息
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		WechatUserInfoT userInfo = wechatuserService.selectEntity(map);

		switch (xmlEntity.getEvent()) {
		case MessageConstanct.EVENT_TYPE_SUBSCRIBE:// 关注
			if (userInfo != null) {
				content = "感谢您的关注！！您已于 " + userInfo.getSubscribeTime() + " 关注该公众号！";
			} else {
				// 首次关注推送消息
				map.put("type", "1");// 类型（1-首次关注；2-联系我们；3-搜索图片）
				WechatPubReplyT pubReply = replyService.selectEntity(map);
				content = pubReply == null ? MessageConstanct.WELCOME_WORDS : pubReply.getContent();

				// 获取微信端用户的信息
				userInfo = getUserInfo(openid);
				if (userInfo != null) {

					// 保存用户的信息
					userInfo.setId(UUIDUtil.getUUID());
					wechatuserService.insert(userInfo);
				} else {
					System.out.println("----获取微信端用户的信息失败----");
				}
			}
			respMessage = new FormatXmlUtil().formatTextAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(),
					content);
			System.out.println("关注--回复文本消息---->" + respMessage);
			break;

		case MessageConstanct.EVENT_TYPE_UNSUBSCRIBE:// 取消关注
			if (userInfo != null) {
				// 删除用户
				wechatuserService.delete(map);
			}
			break;
		}
		return respMessage;
	}

	/**
	 * 回复文本消息-搜索图片功能
	 * 
	 * @param xmlEntity
	 * @return
	 */
	private String todoTextTask(ReceiveXmlVO xmlEntity) {
		String respMessage = null;
		String serial_number = xmlEntity.getContent();
		String from = xmlEntity.getFromUserName();
		String to = xmlEntity.getToUserName();

		// 根据serial_number精确查找
		Map<String, Object> map = new HashMap<>();
		map.put("serial_number", serial_number);
		List<WechatAlbumListT> list = albumService.selectAll(map);
		if (list != null && list.size() > 0) {
			WechatAlbumListT album = list.get(0);
			respMessage = new FormatXmlUtil().formatImgAnswer(from, to, album.getMediaId());
		} else {
			respMessage = new FormatXmlUtil().formatTextAnswer(from, to, MessageConstanct.SEARCH_IMG_NONE_WORDS);
		}
		System.out.println("搜索图片--回复文本消息---->" + respMessage);
		return respMessage;
	}

	/**
	 * 获取用户基本信息
	 * 
	 * @param openid
	 * @return
	 */
	private WechatUserInfoT getUserInfo(String openid) {
		String requestUrl = CfgConstant.GET_USERINFO_URL.replace("_ACCESS_TOKEN", CfgConstant.TOKEN).replace("_OPENID",
				openid);
		WechatUserInfoT user = null;
		try {
			String result = HttpUtil.doGet(requestUrl);
			if (StringUtils.isBlank(result) || StringUtils.contains(result, "errcode")) {
				System.out.println("----获取用户信息失败----" + result);
			} else {
				user = JSON.parseObject(result, WechatUserInfoT.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}