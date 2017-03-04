package com.tywy.sc.controller.wechat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.data.model.WechatUserFavoriteT;
import com.tywy.sc.services.WechatAlbumListTService;
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
	@Resource
	private WechatAlbumListTService albumListService;

	/**
	 * 跳转我的收藏
	 * 
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
			model.addAttribute("resultList", null);
			model.addAttribute("flag", "-1");
			return "wechat/shoucang";
		}

		if (info.getSortFlag() == null) {
			info.setSortFlag(1);// 默认升序排列
		}

		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> resultMap = new HashMap<>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", info.getUserid());
		map.put("sort", "createDate");
		List<WechatUserFavoriteT> favouriteList = service.selectAll(map);
		if (favouriteList != null && favouriteList.size() > 0) {

			List<String> imageUuidList = new ArrayList<String>();
			for (WechatUserFavoriteT entity : favouriteList) {
				imageUuidList.add(entity.getImgUid());
			}
			// 获取图片对象
			List<WechatAlbumListT> list = albumListService.selectByIds(imageUuidList);
			Map<String, WechatAlbumListT> picMap = new HashMap<String, WechatAlbumListT>();
			for (WechatAlbumListT wechatAlbumListT : list) {
				picMap.put(wechatAlbumListT.getId(), wechatAlbumListT);
			}

			// 根据日期分组生成resultMap
			for (WechatUserFavoriteT favoriteT : favouriteList) {
				// 设置图片的路径
				favoriteT.setAlbum(picMap.get(favoriteT.getImgUid()));

				// 获取日期
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

			// 降序排列
			if (info.getSortFlag() == 2) {
				Collections.reverse(resultList);
			}
		}

		model.addAttribute("resultList", resultList);
		model.addAttribute("flag", "1");
		model.addAttribute("sortFlag", info.getSortFlag());
		model.addAttribute("userid", info.getUserid());
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
		if (StringUtils.isBlank(favorite.getIds())) {
			writeJsonObject(response, result, "无可收藏的产品", null);
		}

		try {
			// array转List<String>
			List<String> list = Arrays.asList(favorite.getIds().split("-"));
			favorite.setIdList(list);

			String userid = favorite.getUserid();

			List<WechatUserFavoriteT> favoriteTs = service.selectAll(favorite);
			if (CommonUtils.isCollectionNotEmpty(favoriteTs)) {
				if (list.size() == favoriteTs.size()) {
					writeJsonObject(response, 1, "您已经收藏这些图片", null);
				} else {
					List<String> idListOld = new ArrayList<String>();
					List<String> idListNew = new ArrayList<String>();
					// 增量更新
					for (WechatUserFavoriteT wechatUserFavoriteT : favoriteTs) {
						idListNew.add(wechatUserFavoriteT.getImgUid());
					}

					Iterator<String> it = list.iterator();
					while (it.hasNext()) {
						String string = it.next();
						idListOld.add(string);
					}

					// 去掉已经收收藏的图片
					idListOld.removeAll(idListNew);

					if (CommonUtils.isCollectionNotEmpty(idListOld)) {
						result = insertNewFavourite(userid, idListOld);
					}
				}
			} else {
				// 完全新增
				result = insertNewFavourite(userid, list);
			}
			if (result > 0) {
				msg = "操作成功";
			} else {
				msg = "操作失败";
			}
			writeJsonObject(response, result, msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加收藏
	 * 
	 * @param userid
	 * @param idListOld
	 * @return
	 */
	private int insertNewFavourite(String userid, List<String> idListOld) {
		int result = -1;
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		for (String imgUid : idListOld) {
			map.put("id", UUIDUtil.getUUID());
			map.put("imgUid", imgUid);
			map.put("createDate", DateUtils.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			result = service.insert(map);
			if (result <= 0) {
				System.err.println("----用户【" + userid + "】收藏图片id【" + imgUid + "】失败----");
			}
		}
		return result;
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
	public void batchDeleteFavourite(HttpServletRequest request, HttpServletResponse response,
			WechatUserFavoriteT favorite) {
		int result = -1;
		String msg = "";
		if (favorite.getIds() == null) {
			writeJsonObject(response, result, "请求参数为空", null);
		}
		try {
			// array转List<String>
			List<String> idListOld = Arrays.asList(favorite.getIds().split("-"));

			List<WechatUserFavoriteT> favoriteTs = service.selectByIds(idListOld);
			if (favoriteTs != null && favoriteTs.size() == idListOld.size()) {
				result = service.batchDelete(idListOld);
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
	 * 收藏/取消收藏
	 * 
	 * @param request
	 * @param response
	 * @param favorite
	 */

	@RequestMapping(value = "/doFavourite")
	public void doFavourite(HttpServletRequest request, HttpServletResponse response, WechatUserFavoriteT favorite) {
		int result = -1;
		String msg = "";
		if (favorite == null) {
			writeJsonObject(response, result, "请求参数为空", null);
		}

		String userid = favorite.getUserid();
		String imgUid = favorite.getImgUid();

		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("imgUid", imgUid);
		try {
			// 判断图示是否被收藏
			int count = service.selectCount(map);
			if (count > 0) {
				msg = "您已经给收藏该图片";
			} else {
				map.put("id", UUIDUtil.getUUID());
				map.put("createDate", DateUtils.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
				result = service.insert(map);
				if (result > 0) {
					msg = "操作成功";
				} else {
					msg = "操作失败";
					System.err.println("----用户【" + userid + "】收藏图片id【" + imgUid + "】失败----");
				}
			}
			writeJsonObject(response, result, msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
