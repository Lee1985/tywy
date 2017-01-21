package com.tywy.sc.services.impl;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemPictureInfoDao;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.services.SystemPictureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemPictureInfoServiceImpl extends BaseServiceImpl<SystemPictureInfo>
        implements SystemPictureInfoService {

    @Autowired
    private SystemPictureInfoDao dao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(dao);
    }

}