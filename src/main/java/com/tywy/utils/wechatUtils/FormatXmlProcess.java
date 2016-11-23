package com.tywy.utils.wechatUtils;

import java.util.Date;

import com.tywy.utils.UUIDUtil;

/**
 * 封装最终的xml格式结果
 */
public class FormatXmlProcess {
	/**
	 * 封装文字类的返回消息
	 * 
	 * @param toUser
	 * @param fromUser
	 * @param content
	 * @return
	 */
	public String formatTextAnswer(String toUser, String fromUser, String content) {
		StringBuffer sb = new StringBuffer();
		Date date = new Date();
		sb.append("<xml><ToUserName><![CDATA[");
		sb.append(toUser);
		sb.append("]]></ToUserName><FromUserName><![CDATA[");
		sb.append(fromUser);
		sb.append("]]></FromUserName><CreateTime>");
		sb.append(date.getTime());
		sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
		sb.append(content);
		sb.append("]]></Content><MsgId>");
		sb.append(UUIDUtil.getRandomNum(16));
		sb.append("</MsgId></xml>");
		return sb.toString();
	}

	/**
	 * 封装图片类的返回消息
	 * 
	 * @param toUser
	 * @param fromUser
	 * @param picUrl
	 * @return
	 */
	public String formatImgAnswer(String toUser, String fromUser, String picUrl) {
		StringBuffer sb = new StringBuffer();
		Date date = new Date();
		sb.append("<xml><ToUserName><![CDATA[");
		sb.append(toUser);
		sb.append("]]></ToUserName><FromUserName><![CDATA[");
		sb.append(fromUser);
		sb.append("]]></FromUserName><CreateTime>");
		sb.append(date.getTime());
		sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><PicUrl><![CDATA[");
		sb.append(picUrl);
		sb.append("]]></PicUrl><MediaId><![CDATA[");
		sb.append("media_id");
		sb.append("]]></MediaId><MsgId>");
		sb.append(UUIDUtil.getRandomNum(16));
		sb.append("</MsgId></xml>");
		return sb.toString();
	}

}
