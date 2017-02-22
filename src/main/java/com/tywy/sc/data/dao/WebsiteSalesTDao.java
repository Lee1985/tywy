package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WebsiteSalesT;
/**
 * 数据访问接口
 *
 */
public interface WebsiteSalesTDao extends BaseDao<WebsiteSalesT>{
	public String sqlNameSpace=WebsiteSalesTDao.class.getName();
}