package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteDesignTDao;
import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.sc.services.WebsiteDesignTService;

@Service
public class WebsiteDesignTServiceImpl extends BaseServiceImpl<WebsiteDesignT> implements WebsiteDesignTService{

	@Autowired
	private WebsiteDesignTDao websiteDesignTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteDesignTDao);
	}
	
}