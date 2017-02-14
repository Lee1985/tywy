package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteDesignController extends BaseController{
	
	@RequestMapping(value = "designList")
	public String designList(HttpServletRequest request,HttpServletResponse response) {
		return "website/designList";
	}
	
	@RequestMapping(value = "team")
	public String team(HttpServletRequest request,HttpServletResponse response) {
		return "website/team";
	}
	
}
