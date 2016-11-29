package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemMenuInfo;
/**
 * 数据访问接口
 *
 */
public interface SystemMenuInfoDao extends BaseDao<SystemMenuInfo>{
	public String sqlNameSpace=SystemMenuInfoDao.class.getName();
}