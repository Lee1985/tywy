package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WebsiteCaseTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteCaseTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-16 02:32:48 
* @Copyright：
 */
@Controller
public class WebsiteCaseTController extends BaseController {
	@Resource
	private WebsiteCaseTService service;

	@RequestMapping(value = "/websiteCaseTList")
	public String websiteCaseTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/website_case_t_list";
	}

	@RequestMapping(value = "/websiteCaseTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteCaseT> websiteCaseTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteCaseT> pageInfo = new PageInfo<WebsiteCaseT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/websiteCaseTAjaxAll")
	@ResponseBody
	public List<WebsiteCaseT> websiteCaseTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info, Integer page,
			Integer rows) {
		List<WebsiteCaseT> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/websiteCaseTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCaseTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info) {
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

	@RequestMapping(value = "/websiteCaseTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteCaseTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteCaseT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
