package com.tywy.sc.services.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCaseAlbumTDao;
import com.tywy.sc.data.model.WebsiteCaseAlbumT;
import com.tywy.sc.services.WebsiteCaseAlbumTService;
import com.tywy.sc.services.aop.picture.PictureIconKey;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.PictureList;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteCaseAlbumTServiceImpl extends BaseServiceImpl<WebsiteCaseAlbumT> implements WebsiteCaseAlbumTService{

	@Autowired
	private WebsiteCaseAlbumTDao websiteCaseAlbumTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCaseAlbumTDao);
	}
	
	@Override
	@Pictureable
	public PageInfo<WebsiteCaseAlbumT> selectAll(WebsiteCaseAlbumT info, @PictureList PageInfo<WebsiteCaseAlbumT> pageInfo) {
		return super.selectAll(info, pageInfo);
	}
	
	@Override
	@Pictureable
	public int insertWithImage(WebsiteCaseAlbumT info, @PictureKey StreamVO streamVO, @PictureIconKey Map<String,Object> iconMap) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		info.setStatus("1");
		info.setIsDelete("0");
		return websiteCaseAlbumTDao.insert(info);
	}
	
	@Override
	@Pictureable
	public int updateWithImage(WebsiteCaseAlbumT info, @PictureKey StreamVO streamVO,@PictureIconKey Map<String,Object> iconMap) {
		info.setUpdateDate(new Date());
		return websiteCaseAlbumTDao.update(info);
	}
	
}