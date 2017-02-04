package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatAlbumListTDao;
import com.tywy.sc.data.model.WechatAlbumListT;
/**
 * 
 * @author William
 */
@Component
public class WechatAlbumListTDaoImpl extends BaseDaoImpl<WechatAlbumListT> implements WechatAlbumListTDao{
	public WechatAlbumListTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}