package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCategoryTDao;
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.services.WebsiteCategoryTService;

@Service
public class WebsiteCategoryTServiceImpl extends BaseServiceImpl<WebsiteCategoryT> implements WebsiteCategoryTService{

	@Autowired
	private WebsiteCategoryTDao websiteCategoryTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCategoryTDao);
	}
	
}