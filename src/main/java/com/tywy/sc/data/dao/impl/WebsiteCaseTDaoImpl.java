package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteCaseTDao;
import com.tywy.sc.data.model.WebsiteCaseT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteCaseTDaoImpl extends BaseDaoImpl<WebsiteCaseT> implements WebsiteCaseTDao{
	public WebsiteCaseTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}