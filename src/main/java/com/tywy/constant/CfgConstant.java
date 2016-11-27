package com.tywy.constant;

public class CfgConstant {

	/**
	 * 第三方用户唯一凭证
	 */
	public static String APPID = "";
	/**
	 * 第三方用户唯一凭证密钥
	 */
	public static String APPSECRET = "";
	/**
	 * 获取ACCESS_TOKEN接口
	 */
	public static String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=_APPID&secret=_APPSECRET";
	/**
	 * 微信接入token ，用于验证微信接口
	 */
	public static String TOKEN = "";
	/**
	 * ACCESS_TOKEN有效时间(单位：ms)
	 */
	public static int EFFECTIVE_TIME = 700000;
	/**
	 * 获取用户信息接口
	 */
	public static String GET_USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=_ACCESS_TOKEN&openid=_OPENID&lang=zh_CN";
	/**
	 * 客服接口-发消息
	 */
	public static String GET_CUSTOM_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=_ACCESS_TOKEN";
	/**
	 * 获取服务器访问路径
	 */
	public static String GET_SERVER_URL = "";

}
