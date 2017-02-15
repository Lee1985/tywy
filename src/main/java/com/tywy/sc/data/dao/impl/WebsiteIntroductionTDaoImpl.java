package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteIntroductionTDao;
import com.tywy.sc.data.model.WebsiteIntroductionT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteIntroductionTDaoImpl extends BaseDaoImpl<WebsiteIntroductionT> implements WebsiteIntroductionTDao{
	public WebsiteIntroductionTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}