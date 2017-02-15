package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCompanyQualificationTDao;
import com.tywy.sc.data.model.WebsiteCompanyQualificationT;
import com.tywy.sc.services.WebsiteCompanyQualificationTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteCompanyQualificationTServiceImpl extends BaseServiceImpl<WebsiteCompanyQualificationT> implements WebsiteCompanyQualificationTService{

	@Autowired
	private WebsiteCompanyQualificationTDao websiteCompanyQualificationTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCompanyQualificationTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteCompanyQualificationT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setStatus("1");
		info.setIsDelete("0");
		return websiteCompanyQualificationTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteCompanyQualificationT info, @PictureKey StreamVO streamVO) {
		return websiteCompanyQualificationTDao.update(info);
	}
	
}