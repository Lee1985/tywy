package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteHomepageSalesTDao;
import com.tywy.sc.data.model.WebsiteHomepageSalesT;
import com.tywy.sc.services.WebsiteHomepageSalesTService;

@Service
public class WebsiteHomepageSalesTServiceImpl extends BaseServiceImpl<WebsiteHomepageSalesT> implements WebsiteHomepageSalesTService{

	@Autowired
	private WebsiteHomepageSalesTDao websiteHomepageSalesTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteHomepageSalesTDao);
	}
	
}