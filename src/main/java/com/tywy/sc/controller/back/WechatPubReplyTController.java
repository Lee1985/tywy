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
import com.tywy.sc.data.model.WechatPubReplyT;
import com.tywy.sc.services.WechatPubReplyTService;

/**
 * 
 * @ClassName: WechatPubReplyTController
 * @Description: 控制层
 * @author William
 * @date 2016-11-27 14:28:36
 */
@Controller
public class WechatPubReplyTController extends BaseController {
	@Resource
	private WechatPubReplyTService service;

	@RequestMapping(value = "/wechatPubReplyTList")
	public String wechatPubReplyTList(HttpServletRequest request, HttpServletResponse response) {
		return "/back/wechat_pub_reply_t_list";
	}

	@RequestMapping(value = "/wechatPubReplyTAjaxPage")
	@ResponseBody
	public PageInfo<WechatPubReplyT> wechatPubReplyTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WechatPubReplyT info, Integer page, Integer rows) {
		PageInfo<WechatPubReplyT> pageInfo = new PageInfo<WechatPubReplyT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setSort("type");
		info.setOrder("asc");
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatPubReplyTAjaxAll")
	@ResponseBody
	public List<WechatPubReplyT> wechatPubReplyTAjaxAll(HttpServletRequest request, HttpServletResponse response,
			WechatPubReplyT info, Integer page, Integer rows) {
		List<WechatPubReplyT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/wechatPubReplyTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatPubReplyTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatPubReplyT info) {
		int result = 0;
		try {
			result = service.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result, "操作成功", "更新失败！");
	}
}
