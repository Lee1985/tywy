package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteBrandAlbumTDao;
import com.tywy.sc.data.model.WebsiteBrandAlbumT;
import com.tywy.sc.services.WebsiteBrandAlbumTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteBrandAlbumTServiceImpl extends BaseServiceImpl<WebsiteBrandAlbumT> implements WebsiteBrandAlbumTService{

	@Autowired
	private WebsiteBrandAlbumTDao websiteBrandAlbumTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteBrandAlbumTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteBrandAlbumT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		info.setStatus("1");
		info.setIsDelete("0");
		return websiteBrandAlbumTDao.insert(info);
	}

	@Override
	public int updateWithImage(WebsiteBrandAlbumT info, @PictureKey StreamVO streamVO) {
		info.setUpdateDate(new Date());
		return websiteBrandAlbumTDao.update(info);
	}
	
}