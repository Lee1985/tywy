package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WebsiteMessageT;
/**
 * 数据访问接口
 */
public interface WebsiteMessageTDao extends BaseDao<WebsiteMessageT>{
	public String sqlNameSpace=WebsiteMessageTDao.class.getName();
}