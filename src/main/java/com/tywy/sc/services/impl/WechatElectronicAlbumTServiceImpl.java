package com.tywy.sc.services.impl;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatElectronicAlbumTDao;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatElectronicAlbumTServiceImpl extends BaseServiceImpl<WechatElectronicAlbumT> implements WechatElectronicAlbumTService {

    @Autowired
    private WechatElectronicAlbumTDao wechatElectronicAlbumTDao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(wechatElectronicAlbumTDao);
    }

	@Override
	@Pictureable
	public int insertWithImage(WechatElectronicAlbumT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setIsDelete("0");
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		return wechatElectronicAlbumTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WechatElectronicAlbumT info, @PictureKey StreamVO streamVO) {
		info.setUpdateDate(new Date());
		return wechatElectronicAlbumTDao.update(info);
	}

}