package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatHomepageAlbumTDao;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.sc.services.WechatHomepageAlbumTService;

@Service
public class WechatHomepageAlbumTServiceImpl extends BaseServiceImpl<WechatHomepageAlbumT>
		implements WechatHomepageAlbumTService {

	@Autowired
	private WechatHomepageAlbumTDao wechatHomepageAlbumTDao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(wechatHomepageAlbumTDao);
	}

}