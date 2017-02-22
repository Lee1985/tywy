package com.tywy.sc.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.WechatElectronicAlbumTDao;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.sc.services.aop.picture.PictureKey;
import com.tywy.sc.services.aop.picture.Pictureable;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Service
public class WechatElectronicAlbumTServiceImpl extends BaseServiceImpl<WechatElectronicAlbumT> implements WechatElectronicAlbumTService {

    @Autowired
    private WechatElectronicAlbumTDao wechatElectronicAlbumTDao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(wechatElectronicAlbumTDao);
    }

	@Override
	@Pictureable
	public int insertWithImage(WechatElectronicAlbumT info, @PictureKey StreamVO streamVO) {
		info.setId(UUIDUtil.getUUID());
		info.setCreateDate(new Date());
		info.setIsDelete("0");
		info.setCreateDate(new Date());
		info.setUpdateDate(new Date());
		if(info.getOrderList() == null){
			Integer maxOrderList = wechatElectronicAlbumTDao.selectMaxOrderList();
			if(maxOrderList == null){
				info.setOrderList(1);
			}else{
				info.setOrderList(maxOrderList + 1); 
			}
		}
		return wechatElectronicAlbumTDao.insert(info);
	}

	@Override
	public int update(WechatElectronicAlbumT info) {
		WechatElectronicAlbumT albumInfo = wechatElectronicAlbumTDao.selectById(info.getId());
		if(!albumInfo.getOrderList().equals(info.getOrderList())){
			//序号变化了
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("orderList", info.getOrderList());
			List<WechatElectronicAlbumT> list = wechatElectronicAlbumTDao.selectAll(params);
			if(list != null && !list.isEmpty()){
				wechatElectronicAlbumTDao.updateOrderList(info.getOrderList());
			}
		}
		albumInfo.setUpdateDate(new Date());
		albumInfo.setOrderList(info.getOrderList());
		return super.update(albumInfo);
	}

	@Override
	@Pictureable
	public int updateWithImage(WechatElectronicAlbumT info, @PictureKey StreamVO streamVO) {
		WechatElectronicAlbumT albumInfo = wechatElectronicAlbumTDao.selectById(info.getId());
		if(!albumInfo.getOrderList().equals(info.getOrderList())){
			//序号变化了
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("orderList", info.getOrderList());
			List<WechatElectronicAlbumT> list = wechatElectronicAlbumTDao.selectAll(params);
			if(list != null && !list.isEmpty()){
				wechatElectronicAlbumTDao.updateOrderList(info.getOrderList());
			}
		}
		albumInfo.setUpdateDate(new Date());
		albumInfo.setOrderList(info.getOrderList());
		return wechatElectronicAlbumTDao.update(albumInfo);
	}

}