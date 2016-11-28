package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemRoleDao;
import com.tywy.sc.data.model.SystemRole;

@Component
public class SystemRoleDaoImpl extends BaseDaoImpl<SystemRole> implements SystemRoleDao {
	public SystemRoleDaoImpl() {
		setSql_name_space(sqlNameSpace);
	}
}
