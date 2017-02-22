package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteSalesTDao;
import com.tywy.sc.data.model.WebsiteSalesT;
import com.tywy.sc.services.WebsiteSalesTService;

@Service
public class WebsiteSalesTServiceImpl extends BaseServiceImpl<WebsiteSalesT> implements WebsiteSalesTService{

	@Autowired
	private WebsiteSalesTDao websiteSalesTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteSalesTDao);
	}
	
}