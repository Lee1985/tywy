package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteBrandTDao;
import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.services.WebsiteBrandTService;

@Service
public class WebsiteBrandTServiceImpl extends BaseServiceImpl<WebsiteBrandT> implements WebsiteBrandTService{

	@Autowired
	private WebsiteBrandTDao websiteBrandTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteBrandTDao);
	}
	
}