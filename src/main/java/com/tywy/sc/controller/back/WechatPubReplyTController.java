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
import com.tywy.utils.UUIDUtil;

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
		return "/wechat_pub_reply_t_list";
	}

	@RequestMapping(value = "/wechatPubReplyTAjaxPage")
	@ResponseBody
	public PageInfo<WechatPubReplyT> wechatPubReplyTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WechatPubReplyT info, Integer page, Integer rows) {
		PageInfo<WechatPubReplyT> pageInfo = new PageInfo<WechatPubReplyT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
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
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			result = service.insert(info);
			msg = "保存失败！";
		} else {
			result = service.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功", msg);
	}

	@RequestMapping(value = "/wechatPubReplyTAjaxDelete")
	@ResponseBody
	public Map<String, Object> wechatPubReplyTAjaxDelete(HttpServletRequest request, HttpServletResponse response,
			WechatPubReplyT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result, "操作成功", "删除失败！");
	}
}
