package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteNewsController extends BaseController{
	
	@RequestMapping(value = "news")
	public String news(HttpServletRequest request,HttpServletResponse response) {
		return "website/news";
	}
	
	@RequestMapping(value = "newsDetail")
	public String newsDetail(HttpServletRequest request,HttpServletResponse response) {
		return "website/newsDetail";
	}
	
}
