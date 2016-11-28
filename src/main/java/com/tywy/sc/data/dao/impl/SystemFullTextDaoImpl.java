package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemFullTextDao;
import com.tywy.sc.data.model.SystemFullText;

@Component
public class SystemFullTextDaoImpl extends BaseDaoImpl<SystemFullText> implements SystemFullTextDao {
	public SystemFullTextDaoImpl() {
		setSql_name_space(sqlNameSpace);
	}
}