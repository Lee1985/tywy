package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemFileInfo;

/**
 * 数据访问接口
 */
public interface SystemFileInfoDao extends BaseDao<SystemFileInfo> {
	public String sqlNameSpace = SystemFileInfoDao.class.getName();
}