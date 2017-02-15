package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteDesignTDao;
import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.sc.services.WebsiteDesignTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteDesignTServiceImpl extends BaseServiceImpl<WebsiteDesignT> implements WebsiteDesignTService{

	@Autowired
	private WebsiteDesignTDao websiteDesignTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteDesignTDao);
	}
	
	@Override
	@Pictureable
	public int insertWithImage(WebsiteDesignT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setStatus("1");
		info.setIsDelete("0");
		return websiteDesignTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteDesignT info, @PictureKey StreamVO streamVO) {
		return websiteDesignTDao.update(info);
	}
	
}