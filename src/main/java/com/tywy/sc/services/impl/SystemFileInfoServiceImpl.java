package com.tywy.sc.services.impl;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemFileInfoDao;
import com.tywy.sc.data.model.SystemFileInfo;
import com.tywy.sc.services.SystemFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemFileInfoServiceImpl extends BaseServiceImpl<SystemFileInfo> implements SystemFileInfoService {
    @Autowired
    private SystemFileInfoDao dao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(dao);
    }

}