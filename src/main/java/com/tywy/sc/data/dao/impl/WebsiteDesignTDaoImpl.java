package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteDesignTDao;
import com.tywy.sc.data.model.WebsiteDesignT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteDesignTDaoImpl extends BaseDaoImpl<WebsiteDesignT> implements WebsiteDesignTDao{
	public WebsiteDesignTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}