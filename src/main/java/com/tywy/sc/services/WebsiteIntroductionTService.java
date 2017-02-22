package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteIntroductionT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteIntroductionTService extends BaseService<WebsiteIntroductionT>{

	public int insertWithImage(WebsiteIntroductionT info, StreamVO streamVO);

	public int updateWithImage(WebsiteIntroductionT info, StreamVO streamVO);

}
