package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatPubReplyTDao;
import com.tywy.sc.data.model.WechatPubReplyT;
import com.tywy.sc.services.WechatPubReplyTService;

@Service
public class WechatPubReplyTServiceImpl extends BaseServiceImpl<WechatPubReplyT> implements WechatPubReplyTService{

	@Autowired
	private WechatPubReplyTDao wechatPubReplyTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(wechatPubReplyTDao);
	}
	
}