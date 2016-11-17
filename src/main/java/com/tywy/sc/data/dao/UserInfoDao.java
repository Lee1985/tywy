package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.UserInfo;
/**
 * 数据访问接口
 *
 */
public interface UserInfoDao extends BaseDao<UserInfo>{
	public String sqlNameSpace=UserInfoDao.class.getName();
}