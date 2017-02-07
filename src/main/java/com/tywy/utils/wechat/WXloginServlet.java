package com.tywy.utils.wechat;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tywy.constant.CfgConstant;

/**
 * @author Liuheli
 * @ClassName: WXloginServlet
 * @Description: 微信授权请求处理类
 * @date 2016-11-17 16:48:35
 */
@WebServlet("/wxlogin")
public class WXloginServlet extends HttpServlet {

	private static final long serialVersionUID = 6688395005435952973L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUrl = CfgConstant.GET_AUTHORIZE_URL;
		requestUrl = requestUrl.replace("_APPID", CfgConstant.APPID);
		requestUrl = requestUrl.replace("_SECRET", CfgConstant.APPSECRET);
		requestUrl = requestUrl.replace("_SCOPE", CfgConstant._SCOPE);// 静默授权并自动跳转到回调页snsapi_base
		requestUrl = requestUrl.replace("_REDIRECT_URI", URLEncoder.encode(CfgConstant.GET_CALLBACK_URL));// 回调地址

		System.out.println("微信授权请求requestUrl:" + requestUrl);
		resp.sendRedirect(requestUrl);
	}

}
