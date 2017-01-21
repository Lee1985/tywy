package com.tywy.sc.services.impl;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatElectronicAlbumTDao;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.WechatElectronicAlbumTService;
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

}