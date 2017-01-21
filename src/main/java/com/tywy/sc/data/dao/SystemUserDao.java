package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemUser;

import java.util.Map;

public interface SystemUserDao extends BaseDao<SystemUser> {

    public String sqlNameSpace = SystemUserDao.class.getName();

    public SystemUser selectEntity(SystemUser info);

    public SystemUser selectEntity(Map<String, Object> info);
}
