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
import com.tywy.sc.data.model.WebsiteMessageT;
import com.tywy.sc.services.WebsiteMessageTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
 * @ClassName: WebsiteMessageTController
 * @Description: 控制层
 * @author Liuheli
 * @date 2017-02-14 23:08:23
 */
@Controller
public class WebsiteMessageTController extends BaseController {
	@Resource
	private WebsiteMessageTService service;

	@RequestMapping(value = "/websiteMessageTList")
	public String websiteMessageTList(HttpServletRequest request, HttpServletResponse response) {
		return "back/website_message_t_list";
	}

	@RequestMapping(value = "/websiteMessageTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteMessageT> websiteMessageTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WebsiteMessageT info, Integer page, Integer rows) {
		PageInfo<WebsiteMessageT> pageInfo = new PageInfo<WebsiteMessageT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/websiteMessageTAjaxAll")
	@ResponseBody
	public List<WebsiteMessageT> websiteMessageTAjaxAll(HttpServletRequest request, HttpServletResponse response,
			WebsiteMessageT info, Integer page, Integer rows) {
		List<WebsiteMessageT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/websiteMessageTAjaxSave")
	@ResponseBody
	public Map<String, Object> websiteMessageTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WebsiteMessageT info) {
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

	@RequestMapping(value = "/websiteMessageTAjaxDelete")
	@ResponseBody
	public Map<String, Object> websiteMessageTAjaxDelete(HttpServletRequest request, HttpServletResponse response,
			WebsiteMessageT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result, "操作成功", "删除失败！");
	}
}
