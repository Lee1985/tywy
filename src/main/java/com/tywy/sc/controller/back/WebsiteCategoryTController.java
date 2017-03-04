package com.tywy.sc.controller.back;

import java.util.Date;
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
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

/**
 * 
* @ClassName: WebsiteCategoryTController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-12 00:25:48 
* @Copyright：
 */
@Controller
public class WebsiteCategoryTController extends BaseController {
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;

	@RequestMapping(value = "system/websiteCategoryTList")
	public String websiteCategoryTList(HttpServletRequest request,HttpServletResponse response,String code) {
		request.setAttribute("code", code);
		return "back/website_category_list";
	}

	@RequestMapping(value = "system/websiteCategoryTAjaxPage")
	@ResponseBody
	public PageInfo<WebsiteCategoryT> websiteCategoryTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WebsiteCategoryT info, Integer page,
			Integer rows) {
		
		PageInfo<WebsiteCategoryT> pageInfo = new PageInfo<WebsiteCategoryT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		info.setIsDelete(0);
		info.setSort("orderList");
		info.setOrder("asc");
		websiteCategoryTService.selectAll(info, pageInfo);
		return pageInfo;
	}
	
	@RequestMapping(value = "system/websiteCategoryTAjaxAll")
	@ResponseBody
	public List<WebsiteCategoryT> websiteCategoryTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WebsiteCategoryT info, Integer page,
			Integer rows) {
		List<WebsiteCategoryT> results= websiteCategoryTService.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "system/websiteCategoryTAjaxSave")
	@ResponseBody
	public Map<String,Object> websiteCategoryTAjaxSave(HttpServletRequest request,
			HttpServletResponse response, WebsiteCategoryT info,StreamVO streamVO,String operType) {
		int result = 0;
		String msg = "";
		if("news".equals(info.getCode())){
			if (info.getId() == null || info.getId().equals("")) {
				result = websiteCategoryTService.insertWithImage(info,streamVO);
				msg = "保存失败！";
			} else {
				//根据opertyp判断是否需要上传
				if(StringUtils.isBlank(operType)){
					result = websiteCategoryTService.update(info);
				}else{
					result = websiteCategoryTService.updateWithImage(info,streamVO);
				}
				msg = "修改失败！";
			}
		}else{
			if (info.getId() == null || info.getId().equals("")) {
				info.setId(UUIDUtil.getUUID());
				info.setCreateDate(new Date());
				info.setIsDelete(0);
				result = websiteCategoryTService.insert(info);
				msg = "保存失败！";
			} else {
				result = websiteCategoryTService.update(info);
				msg = "修改失败！";
			}
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	@RequestMapping(value = "system/websiteCategoryTAjaxDelete")
	@ResponseBody
	public Map<String,Object> websiteCategoryTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WebsiteCategoryT info) {
		int result = 0;
		try {
			info.setIsDelete(1);
			result = websiteCategoryTService.update(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
	
	@RequestMapping(value = "system/websiteCategoryTAjaxUpdate")
	@ResponseBody
	public Map<String,Object> websiteCategoryTAjaxUpdate(HttpServletRequest request,
			HttpServletResponse response, WebsiteCategoryT info) {
		int result = 0;
		try {
			result = websiteCategoryTService.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
