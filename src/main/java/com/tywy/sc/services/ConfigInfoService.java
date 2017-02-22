package com.tywy.sc.services;

import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface ConfigInfoService extends BaseService<ConfigInfo>{

	public int insertWithImage(ConfigInfo configImageInfo, StreamVO streamVO);

	public int updateWithImage(ConfigInfo configImageInfo, StreamVO streamVO);
	
	public String getConfigValueByKey(String configKey);

}
