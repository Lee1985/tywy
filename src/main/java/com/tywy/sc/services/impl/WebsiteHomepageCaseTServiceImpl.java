package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteHomepageCaseTDao;
import com.tywy.sc.data.model.WebsiteHomepageCaseT;
import com.tywy.sc.services.WebsiteHomepageCaseTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteHomepageCaseTServiceImpl extends BaseServiceImpl<WebsiteHomepageCaseT> implements WebsiteHomepageCaseTService{
	
	@Autowired
	private WebsiteHomepageCaseTDao websiteHomepageCaseTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteHomepageCaseTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteHomepageCaseT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		Integer maxOrderList = websiteHomepageCaseTDao.selectMaxOrderList();
		if(maxOrderList == null){
			info.setOrderList(1);
		}else{
			info.setOrderList(maxOrderList + 1);
		}
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		info.setIsDelete("0");
		return websiteHomepageCaseTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteHomepageCaseT info, @PictureKey StreamVO streamVO) {
		return websiteHomepageCaseTDao.update(info);
	}
	
}