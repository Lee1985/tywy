package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.WechatAlbumRelT;
import com.tywy.sc.services.WechatAlbumRelTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WechatAlbumRelTController 
* @Description: 控制层 
* @author Liuheli 
* @date 2017-01-25 19:03:30 
* @Copyright：
 */
@Controller
public class WechatAlbumRelTController extends BaseController {
	@Resource
	private WechatAlbumRelTService service;

	@RequestMapping(value = "/wechatAlbumRelTList")
	public String wechatAlbumRelTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/wechat_album_rel_t_list";
	}

	@RequestMapping(value = "/wechatAlbumRelTAjaxPage")
	@ResponseBody
	public PageInfo<WechatAlbumRelT> wechatAlbumRelTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WechatAlbumRelT info, Integer page,
			Integer rows) {
		PageInfo<WechatAlbumRelT> pageInfo = new PageInfo<WechatAlbumRelT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatAlbumRelTAjaxAll")
	@ResponseBody
	public List<WechatAlbumRelT> wechatAlbumRelTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WechatAlbumRelT info, Integer page,
			Integer rows) {
		List<WechatAlbumRelT> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/wechatAlbumRelTAjaxSave")
	@ResponseBody
	public Map<String,Object> wechatAlbumRelTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WechatAlbumRelT info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			result = service.insert(info);
			msg = "保存失败！";
		} else {
			result = service.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "/wechatAlbumRelTAjaxDelete")
	@ResponseBody
	public Map<String,Object> wechatAlbumRelTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WechatAlbumRelT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
