package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatAlbumRelTDao;
import com.tywy.sc.data.model.WechatAlbumRelT;
/**
 * 
 * @author William
 */
@Component
public class WechatAlbumRelTDaoImpl extends BaseDaoImpl<WechatAlbumRelT> implements WechatAlbumRelTDao{
	public WechatAlbumRelTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}