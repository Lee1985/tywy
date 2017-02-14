package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteMessageTDao;
import com.tywy.sc.data.model.WebsiteMessageT;
/**
 * 
 * @author William
 */
@Component
public class WebsiteMessageTDaoImpl extends BaseDaoImpl<WebsiteMessageT> implements WebsiteMessageTDao{
	public WebsiteMessageTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}