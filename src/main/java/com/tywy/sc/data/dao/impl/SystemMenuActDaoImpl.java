package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemMenuActDao;
import com.tywy.sc.data.model.SystemMenuAct;
import org.springframework.stereotype.Component;

@Component
public class SystemMenuActDaoImpl extends BaseDaoImpl<SystemMenuAct> implements SystemMenuActDao {
    public SystemMenuActDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}