package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.WechatElectronicAlbumT;

/**
 * 数据访问接口
 */
public interface WechatElectronicAlbumTDao extends BaseDao<WechatElectronicAlbumT> {
    public String sqlNameSpace = WechatElectronicAlbumTDao.class.getName();

	public Integer selectMaxOrderList();

	public Integer updateOrderList(Integer orderList);
}