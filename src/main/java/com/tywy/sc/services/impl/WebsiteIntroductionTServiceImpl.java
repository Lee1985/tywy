package com.tywy.sc.services.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteIntroductionTDao;
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.sc.services.WebsiteIntroductionTService;
import com.tywy.sc.services.aop.picture.PictureIconKey;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.PictureList;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteIntroductionTServiceImpl extends BaseServiceImpl<WebsiteIntroductionT> implements WebsiteIntroductionTService{

	@Autowired
	private WebsiteIntroductionTDao websiteIntroductionTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteIntroductionTDao);
	}
	
	@Override
	@Pictureable
	public PageInfo<WebsiteIntroductionT> selectAll(WebsiteIntroductionT info,@PictureList PageInfo<WebsiteIntroductionT> pageInfo) {
		return super.selectAll(info, pageInfo);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteIntroductionT info, @PictureKey StreamVO streamVO, @PictureIconKey Map<String, Object> iconMap) {
		try {
			setOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setIsDelete("0");
		return websiteIntroductionTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteIntroductionT info, @PictureKey StreamVO streamVO, @PictureIconKey Map<String, Object> iconMap) {
		try {
			updateOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return websiteIntroductionTDao.update(info);
	}
	
}