package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteBrandTDao;
import com.tywy.sc.data.model.WebsiteBrandT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteBrandTDaoImpl extends BaseDaoImpl<WebsiteBrandT> implements WebsiteBrandTDao{
	public WebsiteBrandTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}