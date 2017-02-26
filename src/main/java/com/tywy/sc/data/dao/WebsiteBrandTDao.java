package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WebsiteBrandT;
/**
 * 数据访问接口
 *
 */
public interface WebsiteBrandTDao extends BaseDao<WebsiteBrandT>{
	public String sqlNameSpace=WebsiteBrandTDao.class.getName();

	public Integer selectMaxOrderList();
}