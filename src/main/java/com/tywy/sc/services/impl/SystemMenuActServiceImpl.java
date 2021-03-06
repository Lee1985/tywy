package com.tywy.sc.services.impl;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemMenuActDao;
import com.tywy.sc.data.model.SystemMenuAct;
import com.tywy.sc.services.SystemMenuActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemMenuActServiceImpl extends BaseServiceImpl<SystemMenuAct> implements SystemMenuActService {
    @Autowired
    private SystemMenuActDao dao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(dao);
    }

}