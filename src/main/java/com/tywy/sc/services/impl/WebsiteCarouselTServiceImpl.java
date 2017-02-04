package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCarouselTDao;
import com.tywy.sc.data.model.WebsiteCarouselT;
import com.tywy.sc.services.WebsiteCarouselTService;

@Service
public class WebsiteCarouselTServiceImpl extends BaseServiceImpl<WebsiteCarouselT> implements WebsiteCarouselTService{

	@Autowired
	private WebsiteCarouselTDao websiteCarouselTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCarouselTDao);
	}
	
}