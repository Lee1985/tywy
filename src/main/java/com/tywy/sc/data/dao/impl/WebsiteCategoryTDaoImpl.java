package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteCategoryTDao;
import com.tywy.sc.data.model.WebsiteCategoryT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteCategoryTDaoImpl extends BaseDaoImpl<WebsiteCategoryT> implements WebsiteCategoryTDao{
	public WebsiteCategoryTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}