package com.tywy.sc.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.SystemFullText;
import com.tywy.sc.services.SystemFullTextService;
import com.tywy.utils.UUIDUtil;

@Controller
public class SystemFullTextController extends BaseController {
	@Resource
	private SystemFullTextService service;

	@RequestMapping(value = "/system/systemFullTextEntity")
	public String systemFullTextEntity(HttpServletRequest request, HttpServletResponse response, SystemFullText info) {
		// 1注册协议2咨询客服3等级说明4关于够了啦
		SystemFullText systemFullText = service.selectEntity(info);
		request.setAttribute("entity", systemFullText);
		return "system/system_full_text_detail";
	}

	@RequestMapping(value = "/system/systemFullTextEdit")
	public String systemFullTextEdit(HttpServletRequest request, HttpServletResponse response, SystemFullText info) {
		//
		SystemFullText systemFullText = service.selectEntity(info);
		request.setAttribute("entity", systemFullText);
		return "system/system_full_text_edit";
	}

	@RequestMapping(value = "/system/systemFullTextSave")
	@ResponseBody
	public Object systemFullTextSave(HttpServletRequest request, HttpServletResponse response, SystemFullText info) {
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

}
