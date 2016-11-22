package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemUserInfoDao;
import com.tywy.sc.data.model.SystemUserInfo;
/**
 * 
 * @author mew
 *
 */
@Component
public class SystemUserInfoDaoImpl extends BaseDaoImpl<SystemUserInfo> implements SystemUserInfoDao{
	public SystemUserInfoDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}