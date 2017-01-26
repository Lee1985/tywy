package com.tywy.sc.controller.wechat;

import java.util.ArrayList;
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

	/**
	 * 我的收藏
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 */
	@RequestMapping(value = "/myFavourite")
	public void myFavourite(HttpServletRequest request, HttpServletResponse response, String userid) {
		int result = -1;
		String msg = "";
		if (userid == null) {
			writeJsonObject(response, result, "用户", null);
		}
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			List<WechatUserFavoriteT> list = service.selectAll(map);

			writeJsonObject(response, result, msg, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 收藏（批量）
	 * 
	 * @param request
	 * @param response
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/batchAddFavourite")
	public void batchAddFavourite(HttpServletRequest request, HttpServletResponse response,
			WechatUserFavoriteT favorite) {
		int result = -1;
		String msg = "";
		if (favorite == null) {
			writeJsonObject(response, result, "请求参数为空", null);
		}
		if (favorite.getIdList() == null || favorite.getIdList().size() <= 0) {
			writeJsonObject(response, result, "无可收藏的产品", null);
		}
		try {
			List<String> idList = new ArrayList<>();
			List<WechatUserFavoriteT> favoriteTs = service.selectAll(favorite);
			if (favoriteTs != null && favoriteTs.size() > 0) {
				for (WechatUserFavoriteT wechatUserFavoriteT : favoriteTs) {
					idList.add(wechatUserFavoriteT.getId());
				}
				result = service.batchDelete(idList);
				if (result > 0) {
					msg = "操作成功";
				} else {
					msg = "操作失败";
				}
			}
			writeJsonObject(response, result, msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取消收藏（批量）
	 * 
	 * @param request
	 * @param response
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/batchDeleteFavourite")
	public void batchDeleteFavourite(HttpServletRequest request, HttpServletResponse response, List<String> idList) {
		int result = -1;
		String msg = "";
		if (idList == null) {
			writeJsonObject(response, result, "请求参数为空", null);
		}
		try {

			List<WechatUserFavoriteT> favoriteTs = service.selectByIds(idList);
			if (favoriteTs != null && favoriteTs.size() == idList.size()) {
				result = service.batchDelete(idList);
				if (result > 0) {
					msg = "操作成功";
				} else {
					msg = "操作失败";
				}
			}
			writeJsonObject(response, result, msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
