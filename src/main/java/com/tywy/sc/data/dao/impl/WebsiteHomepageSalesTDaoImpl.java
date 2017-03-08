package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteHomepageSalesTDao;
import com.tywy.sc.data.model.WebsiteHomepageSalesT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteHomepageSalesTDaoImpl extends BaseDaoImpl<WebsiteHomepageSalesT> implements WebsiteHomepageSalesTDao{
	public WebsiteHomepageSalesTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}