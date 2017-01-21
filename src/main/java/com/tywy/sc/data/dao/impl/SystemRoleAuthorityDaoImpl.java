package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemRoleAuthorityDao;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SystemRoleAuthorityDaoImpl extends BaseDaoImpl<SystemRoleAuthority> implements SystemRoleAuthorityDao {
    public SystemRoleAuthorityDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }

    @Override
    public List<Map<String, Object>> selectPermissUrl(SystemUser info) {
        return dao.getSqlSessionTemplate().selectList(sql_name_space + ".selectPermissUrl", info);
    }
}