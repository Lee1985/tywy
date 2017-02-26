package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCategoryTDao;
import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.sc.services.WebsiteCategoryTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.PictureList;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteCategoryTServiceImpl extends BaseServiceImpl<WebsiteCategoryT> implements WebsiteCategoryTService{

	@Autowired
	private WebsiteCategoryTDao websiteCategoryTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCategoryTDao);
	}
	
	@Override
	@Pictureable
	public PageInfo<WebsiteCategoryT> selectAll(WebsiteCategoryT info, @PictureList PageInfo<WebsiteCategoryT> pageInfo) {
		return super.selectAll(info, pageInfo);
	}
	
	@Override
	public int insert(WebsiteCategoryT info) {
		try {
			setOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.insert(info);
	}

	@Override
	public int update(WebsiteCategoryT info) {
		try {
			updateOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.update(info);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteCategoryT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		Integer maxOrderList = websiteCategoryTDao.selectMaxOrderList();
		if(maxOrderList == null){
			info.setOrderList(1);
		}else{
			info.setOrderList(maxOrderList + 1);
		}
		info.setCreateDate(new Date());
		info.setIsDelete(0);
		return websiteCategoryTDao.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteCategoryT info, @PictureKey StreamVO streamVO) {
		return update(info);
	}
	
	
	
}