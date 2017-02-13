package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteNewsT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteNewsTService extends BaseService<WebsiteNewsT>{

	public int insertWithImage(WebsiteNewsT info, StreamVO streamVO);

	public int updateWithImage(WebsiteNewsT info, StreamVO streamVO);

}
