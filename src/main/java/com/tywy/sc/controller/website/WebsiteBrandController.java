package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteBrandController extends BaseController{
	
	@RequestMapping(value = "brand")
	public String brand(HttpServletRequest request,HttpServletResponse response) {
		return "website/brand";
	}
	
}
