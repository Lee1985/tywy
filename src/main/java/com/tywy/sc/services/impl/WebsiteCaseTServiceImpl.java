package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCaseTDao;
import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.sc.services.WebsiteCaseTService;

@Service
public class WebsiteCaseTServiceImpl extends BaseServiceImpl<WebsiteCaseT> implements WebsiteCaseTService{

	@Autowired
	private WebsiteCaseTDao websiteCaseTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCaseTDao);
	}
	
}