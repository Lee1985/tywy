package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WebsiteHomepageBrandT;
/**
 * 数据访问接口
 *
 */
public interface WebsiteHomepageBrandTDao extends BaseDao<WebsiteHomepageBrandT>{
	
	public String sqlNameSpace=WebsiteHomepageBrandTDao.class.getName();

	public Integer selectMaxOrderList();
}