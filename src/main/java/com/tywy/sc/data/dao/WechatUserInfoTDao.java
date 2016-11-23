package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WechatUserInfoT;

/**
 * 数据访问接口
 *
 */
public interface WechatUserInfoTDao extends BaseDao<WechatUserInfoT> {
	public String sqlNameSpace = WechatUserInfoTDao.class.getName();
}