package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteSalesTDao;
import com.tywy.sc.data.model.WebsiteSalesT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteSalesTDaoImpl extends BaseDaoImpl<WebsiteSalesT> implements WebsiteSalesTDao{
	public WebsiteSalesTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}