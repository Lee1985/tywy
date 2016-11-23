package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatUserInfoTDao;
import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.services.WechatUserInfoTService;

@Service
public class WechatUserInfoTServiceImpl extends BaseServiceImpl<WechatUserInfoT> implements WechatUserInfoTService{

	@Autowired
	private WechatUserInfoTDao wechatUserInfoTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(wechatUserInfoTDao);
	}
	
}