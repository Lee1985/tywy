package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WebsiteNewsT;
/**
 * 数据访问接口
 *
 */
public interface WebsiteNewsTDao extends BaseDao<WebsiteNewsT>{
	public String sqlNameSpace=WebsiteNewsTDao.class.getName();
}