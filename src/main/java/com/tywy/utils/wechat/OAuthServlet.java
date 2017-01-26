package com.tywy.utils.wechat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tywy.constant.CfgConstant;
import com.tywy.sc.data.model.wechat.Oauth2TokenVO;

/**
 * @author Liuheli
 * @ClassName: OAuthServlet
 * @Description: 授权后的回调请求处理类
 * @date 2016-11-17 16:48:35
 */
public class OAuthServlet extends HttpServlet {

	private static final long serialVersionUID = -1847238807216447030L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 用户同意授权后，能获取到code
		String code = request.getParameter("code");
		// String state = request.getParameter("state");

		// 用户同意授权
		if (!"authdeny".equals(code)) {
			// 获取网页授权access_token
			Oauth2TokenVO weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(CfgConstant.APPID,
					CfgConstant.APPSECRET, code);
			// 网页授权接口访问凭证
			// String accessToken = weixinOauth2Token.getAccessToken();
			// 用户标识
			String openid = weixinOauth2Token.getOpenid();

			// 设置要传递的参数
			request.setAttribute("openid", openid);
			// request.setAttribute("state", state);
		}
		// 跳转到index.jsp
		request.getRequestDispatcher("/welcomeIndex.do").forward(request, response);
	}
}