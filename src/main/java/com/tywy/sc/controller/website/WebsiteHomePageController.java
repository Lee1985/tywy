package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteHomePageController extends BaseController{
	
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "website/index";
	}
	
	@RequestMapping(value = "header")
	public String header(HttpServletRequest request,HttpServletResponse response) {
		return "website/index";
	}
	
	@RequestMapping(value = "footer")
	public String footer(HttpServletRequest request,HttpServletResponse response) {
		return "website/footer";
	}
	
	@RequestMapping(value = "floated")
	public String floated(HttpServletRequest request,HttpServletResponse response) {
		return "website/floated";
	}
}
