package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.ConfigInfoDao;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.services.ConfigInfoService;

@Service
public class ConfigInfoServiceImpl extends BaseServiceImpl<ConfigInfo> implements ConfigInfoService{

	@Autowired
	private ConfigInfoDao configInfoDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(configInfoDao);
	}
	
}