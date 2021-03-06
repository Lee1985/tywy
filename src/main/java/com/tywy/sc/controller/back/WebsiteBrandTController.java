package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.services.WebsiteBrandTService;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteBrandTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-13 03:54:25 
* @Copyright：
 */
@Controller
public class WebsiteBrandTController extends BaseController {
	
	@Resource
	private WebsiteBrandTService websiteBrandTService;

	@RequestMapping(value = "system/websiteBrandTList")
	public String websiteBrandTList(HttpServletRequest request,HttpServletResponse response) {
		return "back/website_brand_list";
	}
	
	@RequestMapping(value = "system/websiteBrandTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteBrandT> websiteBrandTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info, Integer page,
			Integer rows) {
		PageInfo<WebsiteBrandT> pageInfo = new PageInfo<WebsiteBrandT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete("0");
		info.setSort("orderList");
		info.setOrder("asc");
		websiteBrandTService.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "system/websiteBrandTAjaxAll")
	@ResponseBody
	public List<WebsiteBrandT> websiteBrandTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info, Integer page,
			Integer rows) {
		List<WebsiteBrandT> results= websiteBrandTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteBrandTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteBrandTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setCreateUser(getSessionUser(request).getId());
			result = websiteBrandTService.insertWithImage(info,streamVO);
			msg = "保存失败！";
		} else {
			//根据opertyp判断是否需要上传
			if(StringUtils.isBlank(operType)){
				result = websiteBrandTService.update(info);
			}else{
				result = websiteBrandTService.updateWithImage(info,streamVO);
			}
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "system/websiteBrandTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteBrandTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info) {
		int result = 0;
		try {
			info.setIsDelete("1");
			result = websiteBrandTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteBrandTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteBrandTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteBrandT info) {
		int result = 0;
		try {
			result = websiteBrandTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
