package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteNewsTDao;
import com.tywy.sc.data.model.WebsiteNewsT;
import com.tywy.sc.services.WebsiteNewsTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteNewsTServiceImpl extends BaseServiceImpl<WebsiteNewsT> implements WebsiteNewsTService{

	@Autowired
	private WebsiteNewsTDao websiteNewsTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteNewsTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteNewsT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setIsDelete("0");
		return websiteNewsTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteNewsT info, @PictureKey StreamVO streamVO) {
		return websiteNewsTDao.update(info);
	}
	
}