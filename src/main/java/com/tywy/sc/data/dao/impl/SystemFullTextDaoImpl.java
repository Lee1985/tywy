package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemFullTextDao;
import com.tywy.sc.data.model.SystemFullText;
import org.springframework.stereotype.Component;

@Component
public class SystemFullTextDaoImpl extends BaseDaoImpl<SystemFullText> implements SystemFullTextDao {
    public SystemFullTextDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}