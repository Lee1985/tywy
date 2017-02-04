package com.tywy.sc.data.dao;

import java.util.List;
import java.util.Map;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUser;

/**
 * 数据访问接口
 */
public interface SystemRoleAuthorityDao extends BaseDao<SystemRoleAuthority> {

    public String sqlNameSpace = SystemRoleAuthorityDao.class.getName();

    public List<Map<String, Object>> selectPermissUrl(SystemUser info);
}