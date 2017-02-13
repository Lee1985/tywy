package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteBrandAlbumTDao;
import com.tywy.sc.data.model.WebsiteBrandAlbumT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteBrandAlbumTDaoImpl extends BaseDaoImpl<WebsiteBrandAlbumT> implements WebsiteBrandAlbumTDao{
	public WebsiteBrandAlbumTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}