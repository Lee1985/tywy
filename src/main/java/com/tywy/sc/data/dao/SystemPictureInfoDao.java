package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemPictureInfo;

/**
 * 数据访问接口
 */
public interface SystemPictureInfoDao extends BaseDao<SystemPictureInfo> {
    public String sqlNameSpace = SystemPictureInfoDao.class.getName();
}