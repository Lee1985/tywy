package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteHomepageCaseTDao;
import com.tywy.sc.data.model.WebsiteHomepageCaseT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteHomepageCaseTDaoImpl extends BaseDaoImpl<WebsiteHomepageCaseT> implements WebsiteHomepageCaseTDao{
	public WebsiteHomepageCaseTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}

	@Override
	public Integer selectMaxOrderList() {
		return dao.getSqlSessionTemplate().selectOne(sql_name_space + ".selectMaxOrderList");
	}
}