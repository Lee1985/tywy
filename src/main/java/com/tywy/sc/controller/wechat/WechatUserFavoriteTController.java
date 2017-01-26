package com.tywy.sc.controller.wechat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WechatUserFavoriteT;
import com.tywy.sc.services.WechatUserFavoriteTService;

/**
 * 
 * @ClassName: WechatUserFavoriteTController
 * @Description: 微信用户收藏控制层
 * @author Liuheli
 * @date 2017-01-25 20:09:48
 */
@Controller
public class WechatUserFavoriteTController extends BaseController {
	@Resource
	private WechatUserFavoriteTService service;

	/**
	 * 跳转我的收藏
	 */
	@RequestMapping(value = "/toCollection")
	public String toCollection(HttpServletRequest request, HttpServletResponse response, Model model, String userid) {

		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		List<WechatUserFavoriteT> favoriteTs = service.selectAll(map);
		model.addAttribute("list", favoriteTs);
		return "wechat/shoucang";
	}
}
