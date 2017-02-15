package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteMessageTDao;
import com.tywy.sc.data.model.WebsiteMessageT;
import com.tywy.sc.services.WebsiteMessageTService;

@Service
public class WebsiteMessageTServiceImpl extends BaseServiceImpl<WebsiteMessageT> implements WebsiteMessageTService{

	@Autowired
	private WebsiteMessageTDao websiteMessageTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteMessageTDao);
	}
	
}