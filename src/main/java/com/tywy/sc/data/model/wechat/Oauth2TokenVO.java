package com.tywy.sc.data.model.wechat;

/**
 * 网页授权信息
 * 
 * @author Liuheli
 */
public class Oauth2TokenVO {

	private String access_token;// 网页授权接口调用凭证
	private int expires_in;// 凭证有效时长
	private String refresh_token;// 用于刷新凭证
	private String openid;// 用户标识
	private String scope;// 用户授权作用域

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}