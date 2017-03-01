package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteDesignMemberT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteDesignMemberTService extends BaseService<WebsiteDesignMemberT>{

	public int insertWithImage(WebsiteDesignMemberT info, StreamVO streamVO);

	public int updateWithImage(WebsiteDesignMemberT info, StreamVO streamVO);

}
