package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WebsiteBrandTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteBrandTController 
* @Description: 控制层 
* @author lipeng 
* @date 2016-12-02 10:50:20 
* @Copyright：
 */
@Controller
public class WebsiteBrandTController extends BaseController {
	
	@Resource
	private WebsiteBrandTService service;

	@RequestMapping(value = "system/websiteBrandTList")
	public String websiteBrandTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "back/website_brand_t_list";
	}

	@RequestMapping(value = "system/websiteBrandTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteBrandT> websiteBrandTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteBrandT> pageInfo = new PageInfo<WebsiteBrandT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/websiteBrandTAjaxAll")
	@ResponseBody
	public List<WebsiteBrandT> websiteBrandTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info, Integer page,
			Integer rows) {
		List<WebsiteBrandT> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/websiteBrandTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteBrandTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info) {
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

	@RequestMapping(value = "/websiteBrandTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteBrandTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
