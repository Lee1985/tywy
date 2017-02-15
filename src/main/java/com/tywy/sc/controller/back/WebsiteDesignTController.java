package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.WebsiteDesignTService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: WebsiteDesignTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-15 17:15:36 
* @Copyright：
 */
@Controller
public class WebsiteDesignTController extends BaseController {
	@Resource
	private WebsiteDesignTService service;

	@RequestMapping(value = "/websiteDesignTList")
	public String websiteDesignTList(HttpServletRequest request,
			HttpServletResponse response) {
		return "/website_design_t_list";
	}

	@RequestMapping(value = "/websiteDesignTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteDesignT> websiteDesignTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteDesignT> pageInfo = new PageInfo<WebsiteDesignT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/websiteDesignTAjaxAll")
	@ResponseBody
	public List<WebsiteDesignT> websiteDesignTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info, Integer page,
			Integer rows) {
		List<WebsiteDesignT> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "/websiteDesignTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteDesignTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info) {
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

	@RequestMapping(value = "/websiteDesignTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteDesignTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteDesignT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
