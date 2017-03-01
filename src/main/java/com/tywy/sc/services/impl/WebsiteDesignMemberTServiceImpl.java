package com.tywy.sc.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WebsiteDesignMemberTDao;
import com.tywy.sc.data.model.WebsiteDesignMemberT;
import com.tywy.sc.services.WebsiteDesignMemberTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.PictureList;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WebsiteDesignMemberTServiceImpl extends BaseServiceImpl<WebsiteDesignMemberT> implements WebsiteDesignMemberTService{

	@Autowired
	private WebsiteDesignMemberTDao websiteDesignMemberTDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(websiteDesignMemberTDao);
	}

	@Override
	@Pictureable
	public PageInfo<WebsiteDesignMemberT> selectAll(WebsiteDesignMemberT info,@PictureList PageInfo<WebsiteDesignMemberT> pageInfo) {
		return super.selectAll(info, pageInfo);
	}

	@Override
	@Pictureable
	public int insertWithImage(WebsiteDesignMemberT info, @PictureKey StreamVO streamVO) {
		try {
			setOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		return super.insert(info);
	}

	@Override
	@Pictureable
	public int updateWithImage(WebsiteDesignMemberT info, @PictureKey StreamVO streamVO) {
		try {
			updateOrderList(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.update(info);
	}
	
	
}