package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteDesignMemberTDao;
import com.tywy.sc.data.model.WebsiteDesignMemberT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteDesignMemberTDaoImpl extends BaseDaoImpl<WebsiteDesignMemberT> implements WebsiteDesignMemberTDao{
	public WebsiteDesignMemberTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}