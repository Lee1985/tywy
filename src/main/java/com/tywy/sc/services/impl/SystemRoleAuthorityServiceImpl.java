package com.tywy.sc.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemRoleAuthorityDao;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUserInfo;
import com.tywy.sc.services.SystemRoleAuthorityService;

@Service
public class SystemRoleAuthorityServiceImpl extends BaseServiceImpl<SystemRoleAuthority> implements SystemRoleAuthorityService{

	@Autowired
	private SystemRoleAuthorityDao systemRoleAuthorityDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(systemRoleAuthorityDao);
	}

	@Override
	public List<Map<String, Object>> selectPermissUrl(SystemUserInfo condition) {
		return systemRoleAuthorityDao.selectPermissUrl(condition);
	}
	
}