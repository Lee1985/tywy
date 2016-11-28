package com.tywy.sc.services;

import java.util.List;
import java.util.Map;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUser;

public interface SystemRoleAuthorityService extends BaseService<SystemRoleAuthority> {
	public int saveAuthority(SystemRoleAuthority info) throws Exception;

	public List<Map<String, Object>> selectPermissUrl(SystemUser info);
}
