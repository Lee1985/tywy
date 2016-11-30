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
import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.services.WechatUserInfoTService;

/**
 * 
 * @ClassName: WechatUserInfoTController
 * @Description: 控制层
 * @author William
 * @date 2016-11-23 21:46:22
 */
@Controller
public class WechatUserInfoTController extends BaseController {
	@Resource
	private WechatUserInfoTService service;

	@RequestMapping(value = "/wechatUserInfoTList")
	public String wechatUserInfoTList(HttpServletRequest request, HttpServletResponse response) {
		return "/back/wechat_user_info_t_list";
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxPage")
	@ResponseBody
	public PageInfo<WechatUserInfoT> wechatUserInfoTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WechatUserInfoT info, Integer page, Integer rows) {
		PageInfo<WechatUserInfoT> pageInfo = new PageInfo<WechatUserInfoT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxAll")
	@ResponseBody
	public List<WechatUserInfoT> wechatUserInfoTAjaxAll(HttpServletRequest request, HttpServletResponse response,
			WechatUserInfoT info, Integer page, Integer rows) {
		List<WechatUserInfoT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxUpdate")
	@ResponseBody
	public Map<String, Object> wechatUserInfoTAjaxUpdate(HttpServletRequest request, HttpServletResponse response,
			WechatUserInfoT info) {
		int result = 0;
		try {
			result = service.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result, "操作成功", "更新失败！");
	}

}
