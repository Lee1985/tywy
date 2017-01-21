package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemPictureInfoDao;
import com.tywy.sc.data.model.SystemPictureInfo;
import org.springframework.stereotype.Component;

@Component
public class SystemPictureInfoDaoImpl extends BaseDaoImpl<SystemPictureInfo> implements SystemPictureInfoDao {
    public SystemPictureInfoDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}