package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.ConfigInfoDao;
import com.tywy.sc.data.model.ConfigInfo;
/**
 * 
 * @author mew
 *
 */
@Component
public class ConfigInfoDaoImpl extends BaseDaoImpl<ConfigInfo> implements ConfigInfoDao{
	public ConfigInfoDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}