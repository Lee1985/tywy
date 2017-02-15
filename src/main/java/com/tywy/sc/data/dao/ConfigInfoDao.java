package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.ConfigInfo;
/**
 * 数据访问接口
 *
 */
public interface ConfigInfoDao extends BaseDao<ConfigInfo>{
	public String sqlNameSpace=ConfigInfoDao.class.getName();
}