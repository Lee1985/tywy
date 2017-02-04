package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatUserFavoriteTDao;
import com.tywy.sc.data.model.WechatUserFavoriteT;
import com.tywy.sc.services.WechatUserFavoriteTService;

@Service
public class WechatUserFavoriteTServiceImpl extends BaseServiceImpl<WechatUserFavoriteT> implements WechatUserFavoriteTService{

	@Autowired
	private WechatUserFavoriteTDao wechatUserFavoriteTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(wechatUserFavoriteTDao);
	}
	
}