package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteHomepageCaseT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteHomepageCaseTService extends BaseService<WebsiteHomepageCaseT>{

	public int insertWithImage(WebsiteHomepageCaseT info, StreamVO streamVO);

	public int updateWithImage(WebsiteHomepageCaseT info, StreamVO streamVO);

}
