package com.tywy.sc.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.ConfigInfoDao;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.sc.services.aop.picture.ConfigPictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class ConfigInfoServiceImpl extends BaseServiceImpl<ConfigInfo> implements ConfigInfoService{

	@Autowired
	private ConfigInfoDao configInfoDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(configInfoDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(ConfigInfo configImageInfo, @ConfigPictureKey StreamVO streamVO) {
		return configInfoDao.insert(configImageInfo);
	}

	@Override
	@Pictureable
	public int updateWithImage(ConfigInfo configImageInfo, @ConfigPictureKey StreamVO streamVO) {
		return configInfoDao.update(configImageInfo);
	}

	@Override
	public String getConfigValueByKey(String configKey) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", "0");
		params.put("status", "1");
		params.put("configKey", configKey);
		ConfigInfo configInfo = super.selectEntity(params);
		if(configInfo == null){
			return null;
		}
		return configInfo.getConfigValue();
	}
	
}