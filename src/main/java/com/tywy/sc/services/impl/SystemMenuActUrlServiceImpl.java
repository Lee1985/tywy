package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemMenuActUrlDao;
import com.tywy.sc.data.model.SystemMenuActUrl;
import com.tywy.sc.services.SystemMenuActUrlService;

@Service
public class SystemMenuActUrlServiceImpl extends BaseServiceImpl<SystemMenuActUrl> implements SystemMenuActUrlService {
	@Autowired
	private SystemMenuActUrlDao dao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(dao);
	}

}