package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteCompanyQualificationT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteCompanyQualificationTService extends BaseService<WebsiteCompanyQualificationT>{

	public int insertWithImage(WebsiteCompanyQualificationT info, StreamVO streamVO);

	public int updateWithImage(WebsiteCompanyQualificationT info, StreamVO streamVO);

}
