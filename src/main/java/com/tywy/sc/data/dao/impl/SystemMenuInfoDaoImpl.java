package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemMenuInfoDao;
import com.tywy.sc.data.model.SystemMenuInfo;
import org.springframework.stereotype.Component;

/**
 * @author mew
 */
@Component
public class SystemMenuInfoDaoImpl extends BaseDaoImpl<SystemMenuInfo> implements SystemMenuInfoDao {
    public SystemMenuInfoDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}