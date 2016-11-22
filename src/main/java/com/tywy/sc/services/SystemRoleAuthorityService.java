package com.tywy.sc.services;

import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUserInfo;

import java.util.List;
import java.util.Map;

import com.tywy.sc.base.service.BaseService;

public interface SystemRoleAuthorityService extends BaseService<SystemRoleAuthority>{

	List<Map<String, Object>> selectPermissUrl(SystemUserInfo condition);

}
