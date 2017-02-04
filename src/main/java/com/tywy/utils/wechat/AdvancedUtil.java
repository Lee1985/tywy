package com.tywy.utils.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.tywy.constant.CfgConstant;
import com.tywy.sc.data.model.wechat.Oauth2TokenVO;

public class AdvancedUtil {

	private static final Logger log = LoggerFactory.getLogger(AdvancedUtil.class);
	private static final String _scope = "snsapi_base";
	// private static final String _redirect_uri = "snsapi_base";

	/**
	 * 获取网页授权凭证
	 * 
	 * @param appId公众账号的唯一标识
	 * @param appSecret公众账号的密钥
	 * @param code
	 * @return WeChatOauth2Token
	 */
	public static Oauth2TokenVO getOauth2AccessToken(String appId, String appSecret, String code) {

		Oauth2TokenVO token = null;
		// 拼接请求地址
		String requestUrl = CfgConstant.GET_AUTHORIZE_URL;
		requestUrl = requestUrl.replace("_APPID", appId);
		requestUrl = requestUrl.replace("_SECRET", appSecret);
		requestUrl = requestUrl.replace("_code", code);
		// 静默授权并自动跳转到回调页
		requestUrl = requestUrl.replace("_SCOPE", _scope);
		// 回调地址
		// requestUrl = requestUrl.replace("_REDIRECT_URI", _redirect_uri);

		// 获取网页授权凭证
		String result = NetWorkCenter.doGet(requestUrl, null);
		if (null != result && !result.contains("errcode") && !result.contains("errmsg")) {
			token = JSONUtil.toBean(result, Oauth2TokenVO.class);
		} else {
			JSONObject object = JSONUtil.getJSONFromString(result);
			log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", object.get("errcode"), object.get("errmsg"));
		}
		return token;
	}
}
