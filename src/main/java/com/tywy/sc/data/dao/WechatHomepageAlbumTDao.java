package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
/**
 * 数据访问接口
 */
public interface WechatHomepageAlbumTDao extends BaseDao<WechatHomepageAlbumT>{
	public String sqlNameSpace=WechatHomepageAlbumTDao.class.getName();

	Integer selectMaxOrderList();
}