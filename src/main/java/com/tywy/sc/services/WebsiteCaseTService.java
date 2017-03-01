package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteCaseT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteCaseTService extends BaseService<WebsiteCaseT>{

	public int insertWithImage(WebsiteCaseT info, StreamVO streamVO);

	public int updateWithImage(WebsiteCaseT info, StreamVO streamVO);

}
