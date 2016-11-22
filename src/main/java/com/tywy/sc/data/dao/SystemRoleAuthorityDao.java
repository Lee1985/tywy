package com.tywy.sc.data.dao;

import java.util.List;
import java.util.Map;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUserInfo;
/**
 * 数据访问接口
 *
 */
public interface SystemRoleAuthorityDao extends BaseDao<SystemRoleAuthority>{
	public String sqlNameSpace=SystemRoleAuthorityDao.class.getName();

	List<Map<String, Object>> selectPermissUrl(SystemUserInfo condition);
}