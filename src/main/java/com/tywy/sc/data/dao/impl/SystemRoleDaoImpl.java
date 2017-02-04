package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemRoleDao;
import com.tywy.sc.data.model.SystemRole;
import org.springframework.stereotype.Component;

@Component
public class SystemRoleDaoImpl extends BaseDaoImpl<SystemRole> implements SystemRoleDao {
    public SystemRoleDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}
