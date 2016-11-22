package com.tywy.sc.data.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemRoleAuthorityDao;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUserInfo;
/**
 * 
 * @author mew
 *
 */
@Component
public class SystemRoleAuthorityDaoImpl extends BaseDaoImpl<SystemRoleAuthority> implements SystemRoleAuthorityDao{
	public SystemRoleAuthorityDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}

	@Override
	public List<Map<String, Object>> selectPermissUrl(SystemUserInfo condition) {
		return dao.getSqlSessionTemplate().selectList(sql_name_space + ".selectPermissUrl", condition);
	}
}