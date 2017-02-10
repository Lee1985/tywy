package com.tywy.sc.services.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteHomepageBrandTDao;
import com.tywy.sc.data.model.WebsiteHomepageBrandT;
import com.tywy.sc.services.WebsiteHomepageBrandTService;
import com.tywy.sc.services.aop.picture.PictureIconKey;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteHomepageBrandTServiceImpl extends BaseServiceImpl<WebsiteHomepageBrandT> implements WebsiteHomepageBrandTService{

	@Autowired
	private WebsiteHomepageBrandTDao websiteHomepageBrandTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteHomepageBrandTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteHomepageBrandT info, @PictureKey StreamVO streamVO, @PictureIconKey Map<String, Object> iconMap) {
		info.setId(UUIDUtil.getUUID());
		Integer maxOrderList = websiteHomepageBrandTDao.selectMaxOrderList();
		if(maxOrderList == null){
			info.setOrderList(1);
		}else{
			info.setOrderList(maxOrderList + 1);
		}
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		info.setIsDelete("0");
		return websiteHomepageBrandTDao.insert(info);
	}
 
	@Override
	@Pictureable
	public int updateWithImage(WebsiteHomepageBrandT info, @PictureKey StreamVO streamVO, @PictureIconKey Map<String, Object> iconMap) {
		return websiteHomepageBrandTDao.update(info);
	}
	
}