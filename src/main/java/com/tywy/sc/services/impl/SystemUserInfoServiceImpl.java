package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemUserInfoDao;
import com.tywy.sc.data.model.SystemUserInfo;
import com.tywy.sc.services.SystemUserInfoService;

@Service
public class SystemUserInfoServiceImpl extends BaseServiceImpl<SystemUserInfo> implements SystemUserInfoService{

	@Autowired
	private SystemUserInfoDao systemUserInfoDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(systemUserInfoDao);
	}
	
}