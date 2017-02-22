package com.tywy.sc.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCategoryTDao;
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.services.WebsiteCategoryTService;

@Service
public class WebsiteCategoryTServiceImpl extends BaseServiceImpl<WebsiteCategoryT> implements WebsiteCategoryTService{

	@Autowired
	private WebsiteCategoryTDao websiteCategoryTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCategoryTDao);
	}

	@Override
	public int insert(WebsiteCategoryT info) {
		if(info.getOrderList() == null){
			Integer maxOrderList = websiteCategoryTDao.selectMaxOrderList();
			if(maxOrderList == null){
				info.setOrderList(1);
			}else{
				info.setOrderList(maxOrderList + 1); 
			}
		}
		return super.insert(info);
	}

	@Override
	public int update(WebsiteCategoryT info) {
		WebsiteCategoryT categoryInfo = websiteCategoryTDao.selectById(info.getId());
		if(info.getOrderList() != null && !categoryInfo.getOrderList().equals(info.getOrderList())){
			//序号变化了
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("orderList", info.getOrderList());
			List<WebsiteCategoryT> list = websiteCategoryTDao.selectAll(params);
			if(list != null && !list.isEmpty()){
				websiteCategoryTDao.updateOrderList(info.getOrderList());
			}
		}
		return super.update(info);
	}
	
	
	
}