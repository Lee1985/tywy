package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteDesignT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteDesignTService extends BaseService<WebsiteDesignT>{

	public int insertWithImage(WebsiteDesignT info, StreamVO streamVO);

	public int updateWithImage(WebsiteDesignT info, StreamVO streamVO);

}
