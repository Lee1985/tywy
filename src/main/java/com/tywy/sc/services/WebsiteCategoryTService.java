package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteCategoryT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteCategoryTService extends BaseService<WebsiteCategoryT>{

	public int insertWithImage(WebsiteCategoryT info, StreamVO streamVO);

	public int updateWithImage(WebsiteCategoryT info, StreamVO streamVO);

}
