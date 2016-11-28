package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemMenuAct;

/**
 * 数据访问接口
 */
public interface SystemMenuActDao extends BaseDao<SystemMenuAct> {
	public String sqlNameSpace = SystemMenuActDao.class.getName();
}