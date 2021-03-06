package com.tywy.sc.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteCaseTDao;
import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.sc.services.WebsiteCaseTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.PictureList;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteCaseTServiceImpl extends BaseServiceImpl<WebsiteCaseT> implements WebsiteCaseTService{

	@Autowired
	private WebsiteCaseTDao websiteCaseTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteCaseTDao);
	}
	
	

	@Override
	public int update(WebsiteCaseT info) {
		try {
			updateOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.update(info);
	}

	@Override
	@Pictureable
	public PageInfo<WebsiteCaseT> selectAll(WebsiteCaseT info, @PictureList PageInfo<WebsiteCaseT> pageInfo) {
		return super.selectAll(info, pageInfo);
	}

	@Override
	@Pictureable
	public List<WebsiteCaseT> selectAll(@PictureList WebsiteCaseT info) {
		return super.selectAll(info);
	}
	
	@Override
	@Pictureable
	public int insertWithImage(WebsiteCaseT info, @PictureKey StreamVO streamVO) {
		try {
			setOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		info.setId(UUIDUtil.getUUID());
		info.setIsDelete("0");
		info.setCreateDate(new Date());
		return super.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteCaseT info, @PictureKey StreamVO streamVO) {
		try {
			updateOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.update(info);
	}
	
}