package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemMenuActUrl;

/**
 * 数据访问接口
 */
public interface SystemMenuActUrlDao extends BaseDao<SystemMenuActUrl> {
    public String sqlNameSpace = SystemMenuActUrlDao.class.getName();
}