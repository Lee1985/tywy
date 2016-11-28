package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemMenuActUrlDao;
import com.tywy.sc.data.model.SystemMenuActUrl;

@Component
public class SystemMenuActUrlDaoImpl extends BaseDaoImpl<SystemMenuActUrl> implements SystemMenuActUrlDao {
	public SystemMenuActUrlDaoImpl() {
		setSql_name_space(sqlNameSpace);
	}
}