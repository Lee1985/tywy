package com.tywy.utils.wechat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.tywy.constant.CfgConstant;
import com.tywy.sc.data.model.wechat.Oauth2TokenVO;

/**
 * @author Liuheli
 * @ClassName: CoreServlet2
 * @Description: 核心请求处理类
 * @date 2016-11-17 16:48:35
 */
@WebServlet("/wxlogin")
public class WXloginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String _scope = "snsapi_userinfo";
//	private static final String _scope = "snsapi_base";
	private static final String _redirect_uri = "http://mywechatpublhl.tunnel.2bdata.com/tywy/callback";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Oauth2TokenVO token = null;
		String requestUrl = CfgConstant.GET_AUTHORIZE_URL;
		requestUrl = requestUrl.replace("_APPID", CfgConstant.APPID);
		requestUrl = requestUrl.replace("_SECRET", CfgConstant.APPSECRET);
		// 静默授权并自动跳转到回调页
		requestUrl = requestUrl.replace("_SCOPE", _scope);
		// 回调地址
		requestUrl = requestUrl.replace("_REDIRECT_URI", _redirect_uri);
		// 获取网页授权凭证
		String result = NetWorkCenter.doGet(requestUrl, null);
		if (null != result && !result.contains("errcode") && !result.contains("errmsg")) {
			token = JSONUtil.toBean(result, Oauth2TokenVO.class);
			System.out.printf("获取网页授权凭证成功 token:{}", token.getAccess_token());
		} else {
			JSONObject object = JSONUtil.getJSONFromString(result);
			System.out.printf("获取网页授权凭证失败 errcode:{} errmsg:{}", object.get("errcode"), object.get("errmsg"));
		}

	}

}
