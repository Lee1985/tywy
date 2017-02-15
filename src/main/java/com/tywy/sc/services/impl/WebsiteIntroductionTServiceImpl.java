package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteIntroductionTDao;
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.sc.services.WebsiteIntroductionTService;

@Service
public class WebsiteIntroductionTServiceImpl extends BaseServiceImpl<WebsiteIntroductionT> implements WebsiteIntroductionTService{

	@Autowired
	private WebsiteIntroductionTDao websiteIntroductionTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteIntroductionTDao);
	}
	
}