package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCarouselTDao;
import com.tywy.sc.data.model.WebsiteCarouselT;
import com.tywy.sc.services.WebsiteCarouselTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteCarouselTServiceImpl extends BaseServiceImpl<WebsiteCarouselT> implements WebsiteCarouselTService{

	@Autowired
	private WebsiteCarouselTDao websiteCarouselTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCarouselTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteCarouselT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setType(1);	
		Integer maxOrderList = websiteCarouselTDao.selectMaxOrderList();
		if(maxOrderList == null){
			info.setOrderList(1);
		}else{
			info.setOrderList(maxOrderList + 1);
		}
		info.setCreateDate(new Date());
		info.setIsDelete(0);
		return websiteCarouselTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteCarouselT info, @PictureKey StreamVO streamVO) {
		return websiteCarouselTDao.update(info);
	}
	
}