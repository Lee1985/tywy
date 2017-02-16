package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatAlbumListTDao;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WechatAlbumListTServiceImpl extends BaseServiceImpl<WechatAlbumListT> implements WechatAlbumListTService{

	@Autowired
	private WechatAlbumListTDao wechatAlbumListTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(wechatAlbumListTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WechatAlbumListT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		info.setIsDelete("0");
		return wechatAlbumListTDao.insert(info);
	}

	@Override
	public int updateWithImage(WechatAlbumListT info, @PictureKey StreamVO streamVO) {
		info.setUpdateDate(new Date());
		return wechatAlbumListTDao.update(info);
	}
	
}