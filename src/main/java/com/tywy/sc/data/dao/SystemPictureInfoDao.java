package com.tywy.sc.data.dao;

import java.util.List;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemPictureInfo;

/**
 * 数据访问接口
 */
public interface SystemPictureInfoDao extends BaseDao<SystemPictureInfo> {
	
	public String sqlNameSpace = SystemPictureInfoDao.class.getName();
	
	/**
	 * 根据uuid集合查询图片信息列表
	 * @param uuidList
	 * @return
	 */
	public List<SystemPictureInfo> selectByUuids(List<String> uuidList);
	
	/**
	 * 根据uuid查找图片信息
	 * @param uuid
	 * @return
	 */
	public SystemPictureInfo selectEntityByUuid(String uuid);
}