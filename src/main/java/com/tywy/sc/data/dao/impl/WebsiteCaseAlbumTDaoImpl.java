package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteCaseAlbumTDao;
import com.tywy.sc.data.model.WebsiteCaseAlbumT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteCaseAlbumTDaoImpl extends BaseDaoImpl<WebsiteCaseAlbumT> implements WebsiteCaseAlbumTDao{
	public WebsiteCaseAlbumTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}