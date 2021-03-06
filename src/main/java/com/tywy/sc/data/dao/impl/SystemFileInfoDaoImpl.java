package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemFileInfoDao;
import com.tywy.sc.data.model.SystemFileInfo;
import org.springframework.stereotype.Component;

@Component
public class SystemFileInfoDaoImpl extends BaseDaoImpl<SystemFileInfo> implements SystemFileInfoDao {
    public SystemFileInfoDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}