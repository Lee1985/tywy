package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteHomepageBrandTDao;
import com.tywy.sc.data.model.WebsiteHomepageBrandT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteHomepageBrandTDaoImpl extends BaseDaoImpl<WebsiteHomepageBrandT> implements WebsiteHomepageBrandTDao{
	public WebsiteHomepageBrandTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}