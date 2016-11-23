package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WechatUserInfoTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WechatUserInfoTController 
* @Description: 控制层 
* @author William 
* @date 2016-11-23 21:46:22 
* @Copyright：
 */
@Controller
public class WechatUserInfoTController extends BaseController {
	@Resource
	private WechatUserInfoTService service;

	@RequestMapping(value = "/wechatUserInfoTList")
	public String wechatUserInfoTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/wechat_user_info_t_list";
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxPage")
	@ResponseBody
	public PageInfo<WechatUserInfoT> wechatUserInfoTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WechatUserInfoT info, Integer page,
			Integer rows) {
		PageInfo<WechatUserInfoT> pageInfo = new PageInfo<WechatUserInfoT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxAll")
	@ResponseBody
	public List<WechatUserInfoT> wechatUserInfoTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WechatUserInfoT info, Integer page,
			Integer rows) {
		List<WechatUserInfoT> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/wechatUserInfoTAjaxSave")
	@ResponseBody
	public Map<String,Object> wechatUserInfoTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WechatUserInfoT info) {
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

	@RequestMapping(value = "/wechatUserInfoTAjaxDelete")
	@ResponseBody
	public Map<String,Object> wechatUserInfoTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WechatUserInfoT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
