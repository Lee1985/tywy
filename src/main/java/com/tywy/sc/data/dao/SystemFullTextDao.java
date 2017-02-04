package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemFullText;

/**
 * 数据访问接口
 */
public interface SystemFullTextDao extends BaseDao<SystemFullText> {
    public String sqlNameSpace = SystemFullTextDao.class.getName();
}