package com.tywy.sc.services;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.SystemRoleAuthority;
import com.tywy.sc.data.model.SystemUser;

import java.util.List;
import java.util.Map;

public interface SystemRoleAuthorityService extends BaseService<SystemRoleAuthority> {
    int saveAuthority(SystemRoleAuthority info) throws Exception;

    List<Map<String, Object>> selectPermissUrl(SystemUser info);
}
