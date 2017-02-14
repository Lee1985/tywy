package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteSalesNetController extends BaseController{
	
	@RequestMapping(value = "map")
	public String map(HttpServletRequest request,HttpServletResponse response) {
		return "website/map";
	}
	
}
