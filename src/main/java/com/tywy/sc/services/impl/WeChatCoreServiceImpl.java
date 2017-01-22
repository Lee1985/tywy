package com.tywy.sc.services.impl;

import com.alibaba.fastjson.JSON;
import com.tywy.constant.CfgConstant;
import com.tywy.constant.MessageConstanct;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.data.model.WechatPubReplyT;
import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.data.model.wechat.AccessTokenVO;
import com.tywy.sc.data.model.wechat.ReceiveXmlVO;
import com.tywy.sc.services.WeChatCoreService;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.sc.services.WechatPubReplyTService;
import com.tywy.sc.services.WechatUserInfoTService;
import com.tywy.utils.DateUtils;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.wechat.FormatXmlUtil;
import com.tywy.utils.wechat.JSONUtil;
import com.tywy.utils.wechat.NetWorkCenter;
import com.tywy.utils.wechat.ReceiveXmlUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeChatCoreServiceImpl extends BaseServiceImpl<ReceiveXmlVO> implements WeChatCoreService {

    @Autowired
    private WechatUserInfoTService wechatuserService;
    @Autowired
    private WechatPubReplyTService replyService;
    @Autowired
    private WechatAlbumListTService albumService;

    private static final Logger logger = LoggerFactory.getLogger(WeChatCoreServiceImpl.class);

    /**
     * 处理微信请求信息
     */
    @Override
    public String processRequest(HttpServletRequest request) throws IOException {
        String respMessage = null;

        // 调用消息工具类ReceiveXmlUtil解析微信发来的xml格式的消息
        String xml = ReceiveXmlUtil.parseXml(request);
        logger.debug("-----------------xml:{}-----------------", xml);

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

                    // 获取access_token
                    String access_token = getAccessToken();
                    if (StringUtils.isNotBlank(access_token)) {

                        // 获取微信端用户的信息
                        userInfo = getUserInfo(openid, access_token);
                        if (userInfo != null) {
                            logger.debug("-----------------userInfo:{}-----------------", userInfo.toString());

                            // 保存用户的信息
                            userInfo.setId(UUIDUtil.getUUID());
                            userInfo.setSubscribeTime(DateUtils.getDateTimeFormat(new Date()));
                            wechatuserService.insert(userInfo);
                        } else {
                            logger.warn("-----------------获取微信端用户的信息失败-----------------");
                        }
                    }
                }
                respMessage = new FormatXmlUtil().formatTextAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(),
                        content);
                logger.debug("-----------------关注--回复文本消息:{}-----------------", respMessage);
                break;

            case MessageConstanct.EVENT_TYPE_UNSUBSCRIBE:// 取消关注
                if (userInfo != null) {
                    // 删除用户
                    wechatuserService.delete(map);
                }
                break;

            case MessageConstanct.EVENT_TYPE_CLICK:// 点击事件
                respMessage = this.todoMenuClick(xmlEntity);
                break;
        }

        return respMessage;
    }

    /**
     * 菜单点击事件
     *
     * @param xmlEntity
     * @return
     */
    private String todoMenuClick(ReceiveXmlVO xmlEntity) {
        String respMessage = null;

        switch (xmlEntity.getEventKey()) {
            case MessageConstanct.MENU_CLICK_CONTACT:// 联系我们
                respMessage = this.todoMenuClickMethod(xmlEntity, 2);
                break;
            case MessageConstanct.MENU_CLICK_SEARCH:// 搜索图片
                respMessage = this.todoMenuClickMethod(xmlEntity, 3);
                break;
        }
        return respMessage;
    }

    /**
     * 菜单点击方法
     *
     * @param xmlEntity
     * @param type
     * @return
     */
    private String todoMenuClickMethod(ReceiveXmlVO xmlEntity, int type) {
        // 首次关注推送消息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);// 类型（1-首次关注；2-联系我们；3-搜索图片）
        WechatPubReplyT pubReply = replyService.selectEntity(map);
        String content = pubReply.getContent();
        switch (type) {
            case 2:
                content = StringUtils.isBlank(content) ? MessageConstanct.CONTACT_WELCOME_WORDS : content;
                break;
            case 3:
                content = StringUtils.isBlank(content) ? MessageConstanct.SEARCH_WELCOME_WORDS : content;
                break;
        }
        String respMessage = new FormatXmlUtil().formatTextAnswer(xmlEntity.getFromUserName(),
                xmlEntity.getToUserName(), content);
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
        logger.debug("-----------------搜索图片--回复文本消息:{}-----------------", respMessage);
        return respMessage;
    }

    /**
     * 获取用户基本信息
     *
     * @param openid
     * @param access_token
     * @return
     */
    private WechatUserInfoT getUserInfo(String openid, String access_token) {
        String requestUrl = CfgConstant.GET_USERINFO_URL.replace("_ACCESS_TOKEN", access_token).replace("_OPENID",
                openid);
        WechatUserInfoT user = null;
        try {
            String result = NetWorkCenter.doGet(requestUrl,null);
            if (StringUtils.isBlank(result) || StringUtils.contains(result, "errcode")) {
                logger.error("-----------------requestUrl:{}-----------------", requestUrl);
                logger.error("-----------------获取用户信息失败:{}-----------------", result);
            } else {
                user = JSONUtil.toBean(result, WechatUserInfoT.class);
//              user = JSON.parseObject(result, WechatUserInfoT.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 获取access token
     *
     * @return
     */
    private String getAccessToken() {
        String requestUrl = CfgConstant.GET_ACCESSTOKEN_URL.replace("_APPID", CfgConstant.APPID).replace("_APPSECRET",
                CfgConstant.APPSECRET);
        String token = "";
        try {
            String result = NetWorkCenter.doGet(requestUrl,null);
            if (StringUtils.isBlank(result) || StringUtils.contains(result, "errcode")) {
            	logger.error("getAccessToken requestUrl:{}", requestUrl);
            	logger.error("getAccessToken Fail:{}", result);
            } else {
                AccessTokenVO accessTokenVO = JSON.parseObject(result, AccessTokenVO.class);
                token = accessTokenVO.getAccess_token();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}