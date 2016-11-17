package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.UserInfoDao;
import com.tywy.sc.data.model.UserInfo;
/**
 * 
 * @author mew
 *
 */
@Component
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao{
	public UserInfoDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}