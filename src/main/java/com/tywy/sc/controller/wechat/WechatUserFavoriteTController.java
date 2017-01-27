package com.tywy.sc.controller.wechat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WechatUserFavoriteT;
import com.tywy.sc.services.WechatUserFavoriteTService;
import com.tywy.utils.DateUtils;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.wechat.CommonUtils;

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
	 * @param request
	 * @param response
	 * @param model
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/toCollection")
	public String toCollection(HttpServletRequest request, HttpServletResponse response, Model model,
			WechatUserFavoriteT info) {

		if (info == null || info.getUserid() == null) {
			model.addAttribute("list", null);
			model.addAttribute("flag", "-1");
			return "wechat/shoucang";
		}

		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> resultMap = new HashMap<>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", info.getUserid());
		map.put("sort", "createDate");
		if (info.getSort() == null) {
			map.put("order", "desc");
		} else {
			map.put("order", "asc");
		}
		List<WechatUserFavoriteT> favouriteList = service.selectAll(map);
		if (favouriteList != null && favouriteList.size() > 0) {

			// 根据日期分组生成resultMap
			for (WechatUserFavoriteT favoriteT : favouriteList) {
				String key = favoriteT.getCreateDate();
				List<WechatUserFavoriteT> favoriteTs = new ArrayList<>();
				if (resultMap.containsKey(key)) {
					// 如果包含这个key值,获取value
					favoriteTs = (List<WechatUserFavoriteT>) resultMap.get(key);
				}
				favoriteTs.add(favoriteT);
				resultMap.put(key, favoriteTs);
			}

			// 将resultMap放入resultList
			for (Entry<String, Object> entry : resultMap.entrySet()) {
				Map<String, Object> mapNew = new HashMap<>();
				mapNew.put("createdate", entry.getKey());
				mapNew.put("entity", entry.getValue());
				resultList.add(mapNew);
			}
		}

		model.addAttribute("resultList", resultList);
		return "wechat/shoucang";
	}

	/**
	 * 收藏（批量）
	 * 
	 * @param request
	 * @param response
	 * @param info-idList图片主键
	 * @return
	 */
	@RequestMapping(value = "/batchAddFavourite")
	public void batchAddFavourite(HttpServletRequest request, HttpServletResponse response,
			WechatUserFavoriteT favorite) {
		int result = -1;
		String msg = "";
		if (CommonUtils.isNull(favorite)) {
			writeJsonObject(response, result, "请求参数为空", null);
		}
		if (favorite.getIdList() == null || favorite.getIdList().size() <= 0) {
			writeJsonObject(response, result, "无可收藏的产品", null);
		}

		List<String> idListNew = new ArrayList<>();
		List<String> idListOld = favorite.getIdList();

		try {
			List<WechatUserFavoriteT> favoriteTs = service.selectAll(favorite);
			if (CommonUtils.isCollectionNotEmpty(favoriteTs)) {

				for (WechatUserFavoriteT wechatUserFavoriteT : favoriteTs) {
					idListNew.add(wechatUserFavoriteT.getImgUid());
				}

				boolean flag = false;
				// 去掉已经收收藏的图片
				if (CommonUtils.isCollectionNotEmpty(idListNew)) {
					flag = idListOld.removeAll(idListNew);
				}

				if (CommonUtils.isCollectionNotEmpty(idListOld) && flag) {
					Map<String, Object> map = new HashMap<>();
					map.put("userid", favorite.getUserid());
					for (String imgUid : idListOld) {
						map.put("id", UUIDUtil.getUUID());
						map.put("imgUid", imgUid);
						map.put("createDate", DateUtils.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
						result = service.insert(map);
					}
				}
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
	 * @param idList收藏主键
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
