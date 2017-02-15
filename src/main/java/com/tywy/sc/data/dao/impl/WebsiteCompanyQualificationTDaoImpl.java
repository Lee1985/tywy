package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteCompanyQualificationTDao;
import com.tywy.sc.data.model.WebsiteCompanyQualificationT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteCompanyQualificationTDaoImpl extends BaseDaoImpl<WebsiteCompanyQualificationT> implements WebsiteCompanyQualificationTDao{
	public WebsiteCompanyQualificationTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}