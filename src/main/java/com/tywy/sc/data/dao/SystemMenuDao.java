package com.tywy.sc.data.dao;

import java.util.List;
import java.util.Map;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.SystemMenu;

public interface SystemMenuDao extends BaseDao<SystemMenu> {
	public String sqlNameSpace = SystemMenuDao.class.getName();

	public List<SystemMenu> selectAllByPid(String pid);

	public List<SystemMenu> selectAllByPid(Integer pid);

	public int selectMaxOrderListByPid(SystemMenu info);

	public int selectMaxOrderListByPid(Map<String, Object> info);

	public int updateOrderListDown(SystemMenu info);

	public int updateOrderListUp(SystemMenu info);

	public List<SystemMenu> selectAllByRole(SystemMenu info);

	public List<SystemMenu> selectAllByRoleLogin(SystemMenu info);
}
