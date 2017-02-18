package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatHomepageAlbumTDao;
import com.tywy.sc.data.model.WechatHomepageAlbumT;

/**
 * 
 * @author William
 */
@Component
public class WechatHomepageAlbumTDaoImpl extends BaseDaoImpl<WechatHomepageAlbumT> implements WechatHomepageAlbumTDao {
	public WechatHomepageAlbumTDaoImpl() {
		setSql_name_space(sqlNameSpace);
	}

	@Override
	public Integer selectMaxOrderList() {
		return dao.getSqlSessionTemplate().selectOne(sql_name_space + ".selectMaxOrderList");
	}
}