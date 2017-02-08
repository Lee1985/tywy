package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WebsiteCarouselTDao;
import com.tywy.sc.data.model.WebsiteCarouselT;
/**
 * 
 * @author mew
 *
 */
@Component
public class WebsiteCarouselTDaoImpl extends BaseDaoImpl<WebsiteCarouselT> implements WebsiteCarouselTDao{
	public WebsiteCarouselTDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}

	@Override
	public Integer selectMaxOrderList() {		
		return dao.getSqlSessionTemplate().selectOne(sql_name_space + ".selectMaxOrderList");
	}
}