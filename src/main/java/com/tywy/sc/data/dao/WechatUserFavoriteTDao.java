package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WechatUserFavoriteT;
/**
 * 数据访问接口
 */
public interface WechatUserFavoriteTDao extends BaseDao<WechatUserFavoriteT>{
	public String sqlNameSpace=WechatUserFavoriteTDao.class.getName();
}