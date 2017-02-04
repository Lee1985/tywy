package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemMenuActUrlDao;
import com.tywy.sc.data.model.SystemMenuActUrl;
import org.springframework.stereotype.Component;

@Component
public class SystemMenuActUrlDaoImpl extends BaseDaoImpl<SystemMenuActUrl> implements SystemMenuActUrlDao {
    public SystemMenuActUrlDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}