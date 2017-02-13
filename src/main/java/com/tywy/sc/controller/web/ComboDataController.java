package com.tywy.sc.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.services.WebsiteCategoryTService;

@Controller
public class ComboDataController extends BaseController{
	
	@Resource
	private WebsiteCategoryTService websiteCategoryTService;
	
	@RequestMapping(value = "system/comboCategoryByCode")
	@ResponseBody
	public List<WebsiteCategoryT> comboCategoryByCode(HttpServletRequest request,HttpServletResponse response,String code){
		WebsiteCategoryT category = new WebsiteCategoryT();
		category.setCode(code);
		category.setStatus(1);
		category.setIsDelete(0);
		return websiteCategoryTService.selectAll(category);
	}

}
