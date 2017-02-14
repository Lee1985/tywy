package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteCaseController extends BaseController{
	
	@RequestMapping(value = "classicCase")
	public String classicCase(HttpServletRequest request,HttpServletResponse response) {
		return "website/classicCase";
	}
	
}
