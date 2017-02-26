package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteBrandTDao;
import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.sc.services.WebsiteBrandTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.PictureList;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteBrandTServiceImpl extends BaseServiceImpl<WebsiteBrandT> implements WebsiteBrandTService{

	@Autowired
	private WebsiteBrandTDao websiteBrandTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteBrandTDao);
	}
	
	@Override
	@Pictureable
	public PageInfo<WebsiteBrandT> selectAll(WebsiteBrandT info, @PictureList PageInfo<WebsiteBrandT> pageInfo) {
		return super.selectAll(info, pageInfo);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteBrandT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		try {
			setOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		info.setCreateDate(new Date());
		info.setIsDelete("0");
		return websiteBrandTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteBrandT info, @PictureKey StreamVO streamVO) {
		try {
			updateOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return websiteBrandTDao.update(info);
	}
	
}