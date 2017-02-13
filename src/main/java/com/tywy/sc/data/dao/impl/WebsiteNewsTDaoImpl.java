package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteNewsTDao;
import com.tywy.sc.data.model.WebsiteNewsT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteNewsTDaoImpl extends BaseDaoImpl<WebsiteNewsT> implements WebsiteNewsTDao{
	public WebsiteNewsTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}