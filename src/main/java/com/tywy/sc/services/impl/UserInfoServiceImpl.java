package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.UserInfoDao;
import com.tywy.sc.data.model.UserInfo;
import com.tywy.sc.services.UserInfoService;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(userInfoDao);
	}
	
}