package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemFullTextDao;
import com.tywy.sc.data.model.SystemFullText;
import com.tywy.sc.services.SystemFullTextService;

@Service
public class SystemFullTextServiceImpl extends BaseServiceImpl<SystemFullText> implements SystemFullTextService {
	@Autowired
	private SystemFullTextDao dao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(dao);
	}

}