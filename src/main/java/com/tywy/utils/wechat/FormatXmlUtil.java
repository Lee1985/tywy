package com.tywy.utils.wechat;

import java.util.Date;

/**
 * 封装最终的xml格式结果
 */
public class FormatXmlUtil {
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
        sb.append(content.trim());
        sb.append("]]></Content></xml>");
        return sb.toString();
    }

    /**
     * 封装图片类的返回消息
     *
     * @param toUser
     * @param fromUser
     * @param mediaId
     * @return
     */
    public String formatImgAnswer(String toUser, String fromUser, String mediaId) {
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        sb.append("<xml><ToUserName><![CDATA[");
        sb.append(toUser);
        sb.append("]]></ToUserName><FromUserName><![CDATA[");
        sb.append(fromUser);
        sb.append("]]></FromUserName><CreateTime>");
        sb.append(date.getTime());
        sb.append("</CreateTime><MsgType><![CDATA[image]]></MsgType><Image><MediaId><![CDATA[");
        sb.append(mediaId);
        sb.append("]]></MediaId></Image></xml>");
        return sb.toString();
    }

}
