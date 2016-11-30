package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.SystemPictureInfoDao;
import com.tywy.sc.data.model.SystemPictureInfo;

@Component
public class SystemPictureInfoDaoImpl extends BaseDaoImpl<SystemPictureInfo> implements SystemPictureInfoDao {
	public SystemPictureInfoDaoImpl() {
		setSql_name_space(sqlNameSpace);
	}
}