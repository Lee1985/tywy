package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemRoleDao;
import com.tywy.sc.data.model.SystemRole;
import com.tywy.sc.services.SystemRoleService;

@Service
public class SystemRoleServiceImpl extends BaseServiceImpl<SystemRole> implements SystemRoleService {
	
	@Autowired
	private SystemRoleDao systemRoleDao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(systemRoleDao);
	}
}