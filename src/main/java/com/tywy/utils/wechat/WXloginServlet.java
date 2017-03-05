package com.tywy.utils.wechat;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tywy.constant.CfgConstant;

/**
 * @author Liuheli
 * @ClassName: WXloginServlet
 * @Description: 微信授权请求处理类
 * @date 2016-11-17 16:48:35
 */
@WebServlet("/weixin/oauth")
public class WXloginServlet extends HttpServlet {

	private static final long serialVersionUID = 6688395005435952973L;
	private static final Logger log = LoggerFactory.getLogger(WXloginServlet.class);

	/**
	 * 微信授权回调
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");

		if (null != code && !"".equals(code)) {
			log.info("==============[OAuthServlet]获取网页授权code不为空，code=" + code);
			// 根据code换取openId
			OAuthInfo oa = getOAuthOpenId(CfgConstant.APPID, CfgConstant.APPSECRET, code);
			if (!"".equals(oa) && null != oa) {
				request.setAttribute("userid", oa.getOpenid());
				request.getRequestDispatcher("/WEB-INF/views/wechat/index.jsp").forward(request, response);
			} else {
				log.info("==============[OAuthServlet]获取网页授权openId失败！");
			}
		} else {
			log.info("==============[OAuthServlet]获取网页授权code失败！");
		}
	}

	/**
	 * 根据code取得openId
	 * 
	 * @param appid公众号的唯一标识
	 * @param secret公众号的appsecret密钥
	 * @param code为换取access_token的票据
	 */
	private OAuthInfo getOAuthOpenId(String appid, String secret, String code) {

		String requestUrl = CfgConstant.GET_AUTH_OPENID_URL.replace("APPID", appid).replace("SECRET", secret)
				.replace("CODE", code);

		String result = NetWorkCenter.doGet(requestUrl, null);

		return JSONUtil.toBean(result, OAuthInfo.class);
	}
	
	public static void main(String[] args) {
		String string = URLEncoder.encode("http://1c612825a9.iask.in:12087/tywy/weixin/oauth");
//		String string = URLEncoder.encode(CfgConstant.GET_CALLBACK_URL);
		System.out.println(string);
	}
}
