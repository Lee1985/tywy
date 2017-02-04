package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatUserFavoriteTDao;
import com.tywy.sc.data.model.WechatUserFavoriteT;
/**
 * 
 * @author William
 */
@Component
public class WechatUserFavoriteTDaoImpl extends BaseDaoImpl<WechatUserFavoriteT> implements WechatUserFavoriteTDao{
	public WechatUserFavoriteTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}