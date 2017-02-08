package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteHomepageBrandTDao;
import com.tywy.sc.data.model.WebsiteHomepageBrandT;
import com.tywy.sc.services.WebsiteHomepageBrandTService;

@Service
public class WebsiteHomepageBrandTServiceImpl extends BaseServiceImpl<WebsiteHomepageBrandT> implements WebsiteHomepageBrandTService{

	@Autowired
	private WebsiteHomepageBrandTDao websiteHomepageBrandTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteHomepageBrandTDao);
	}
	
}