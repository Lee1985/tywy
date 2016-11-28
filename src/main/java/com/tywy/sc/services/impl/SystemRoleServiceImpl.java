package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemRoleDao;
import com.tywy.sc.data.model.SystemRole;
import com.tywy.sc.services.SystemRoleService;

public class SystemRoleServiceImpl extends BaseServiceImpl<SystemRole> implements SystemRoleService {
	@Autowired
	private SystemRoleDao dao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(dao);
	}
}