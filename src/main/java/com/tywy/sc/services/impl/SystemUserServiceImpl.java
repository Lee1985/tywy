package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemUserDao;
import com.tywy.sc.data.model.SystemUser;
import com.tywy.sc.services.SystemUserService;

@Service
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUser> implements SystemUserService {
	@Autowired
	private SystemUserDao dao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(dao);
	}
}
