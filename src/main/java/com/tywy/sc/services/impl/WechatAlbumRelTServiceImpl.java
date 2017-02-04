package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatAlbumRelTDao;
import com.tywy.sc.data.model.WechatAlbumRelT;
import com.tywy.sc.services.WechatAlbumRelTService;

@Service
public class WechatAlbumRelTServiceImpl extends BaseServiceImpl<WechatAlbumRelT> implements WechatAlbumRelTService{

	@Autowired
	private WechatAlbumRelTDao wechatAlbumRelTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(wechatAlbumRelTDao);
	}
	
}