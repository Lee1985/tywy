package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteHomepageBrandT;
import com.tywy.utils.stream.util.StreamVO;

import java.util.Map;

import com.tywy.sc.base.service.BaseService;

public interface WebsiteHomepageBrandTService extends BaseService<WebsiteHomepageBrandT>{

	public int insertWithImage(WebsiteHomepageBrandT info, StreamVO streamVO, Map<String, Object> iconMap);

	public int updateWithImage(WebsiteHomepageBrandT info, StreamVO streamVO, Map<String, Object> iconMap);

}
