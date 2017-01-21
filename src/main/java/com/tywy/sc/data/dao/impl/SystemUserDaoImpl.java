package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemUserDao;
import com.tywy.sc.data.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SystemUserDaoImpl extends BaseDaoImpl<SystemUser> implements SystemUserDao {
    public SystemUserDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }

    @Override
    public SystemUser selectEntity(SystemUser info) {
        return dao.getSqlSessionTemplate().selectOne(sql_name_space + "." + "selectEntity", info);
    }

    @Override
    public SystemUser selectEntity(Map<String, Object> info) {
        return dao.getSqlSessionTemplate().selectOne(sql_name_space + "." + "selectEntity", info);
    }

}
