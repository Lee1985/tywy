package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatElectronicAlbumTDao;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WechatElectronicAlbumTDaoImpl extends BaseDaoImpl<WechatElectronicAlbumT> implements WechatElectronicAlbumTDao{
	public WechatElectronicAlbumTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}