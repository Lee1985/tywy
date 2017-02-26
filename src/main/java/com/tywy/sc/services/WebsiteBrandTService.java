package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteBrandT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteBrandTService extends BaseService<WebsiteBrandT>{

	public int insertWithImage(WebsiteBrandT info, StreamVO streamVO);

	public int updateWithImage(WebsiteBrandT info, StreamVO streamVO);

}
