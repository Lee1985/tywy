package com.tywy.sc.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebsiteAboutController extends BaseController{
	
	@RequestMapping(value = "companyProfile")
	public String companyProfile(HttpServletRequest request,HttpServletResponse response) {
		return "website/companyProfile";
	}
	
	@RequestMapping(value = "companyQualification")
	public String companyQualification(HttpServletRequest request,HttpServletResponse response) {
		return "website/companyQualification";
	}
	
	@RequestMapping(value = "contact")
	public String contact(HttpServletRequest request,HttpServletResponse response) {
		return "website/contact";
	}
	
	
}
