package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteCarouselT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteCarouselTService extends BaseService<WebsiteCarouselT>{

	public int insertWithImage(WebsiteCarouselT info, StreamVO streamVO);

	public int updateWithImage(WebsiteCarouselT info, StreamVO streamVO);

}
