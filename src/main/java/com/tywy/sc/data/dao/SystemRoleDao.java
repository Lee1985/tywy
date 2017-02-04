package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemRole;

public interface SystemRoleDao extends BaseDao<SystemRole> {
    public String sqlNameSpace = SystemRoleDao.class.getName();
}
