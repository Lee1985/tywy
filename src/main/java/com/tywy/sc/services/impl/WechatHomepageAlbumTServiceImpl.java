package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatHomepageAlbumTDao;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.sc.services.WechatHomepageAlbumTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WechatHomepageAlbumTServiceImpl extends BaseServiceImpl<WechatHomepageAlbumT>
		implements WechatHomepageAlbumTService {

	@Autowired
	private WechatHomepageAlbumTDao wechatHomepageAlbumTDao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(wechatHomepageAlbumTDao);
	}

	@Override
	@Pictureable
	public int insertWithImage(WechatHomepageAlbumT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		Integer maxOrderList = wechatHomepageAlbumTDao.selectMaxOrderList();
		if (maxOrderList == null) {
			info.setOrderList(1);
		} else {
			info.setOrderList(maxOrderList + 1);
		}
		info.setIsDelete(0);
		return wechatHomepageAlbumTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WechatHomepageAlbumT info, @PictureKey StreamVO streamVO) {
		return wechatHomepageAlbumTDao.update(info);
	}

}