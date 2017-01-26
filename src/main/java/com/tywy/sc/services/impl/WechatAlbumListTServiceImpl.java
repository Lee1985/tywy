package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatAlbumListTDao;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.services.WechatAlbumListTService;

@Service
public class WechatAlbumListTServiceImpl extends BaseServiceImpl<WechatAlbumListT> implements WechatAlbumListTService{

	@Autowired
	private WechatAlbumListTDao wechatAlbumListTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(wechatAlbumListTDao);
	}
	
}