package com.tywy.sc.services.impl;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemMenuInfoDao;
import com.tywy.sc.data.model.SystemMenuInfo;
import com.tywy.sc.services.SystemMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemMenuInfoServiceImpl extends BaseServiceImpl<SystemMenuInfo> implements SystemMenuInfoService {

    @Autowired
    private SystemMenuInfoDao systemMenuInfoDao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(systemMenuInfoDao);
    }

}