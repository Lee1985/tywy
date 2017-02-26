package com.tywy.sc.services;

import java.util.Map;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.utils.stream.util.StreamVO;

public interface WebsiteIntroductionTService extends BaseService<WebsiteIntroductionT>{

	public int insertWithImage(WebsiteIntroductionT info, StreamVO streamVO,Map<String,Object> iconMap);

	public int updateWithImage(WebsiteIntroductionT info, StreamVO streamVO,Map<String,Object> iconMap);

}
