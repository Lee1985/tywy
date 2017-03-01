package com.tywy.sc.services;

import java.util.Map;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.WebsiteCaseAlbumT;
import com.tywy.utils.stream.util.StreamVO;

public interface WebsiteCaseAlbumTService extends BaseService<WebsiteCaseAlbumT>{

	public int insertWithImage(WebsiteCaseAlbumT info, StreamVO streamVO,Map<String,Object> iconMap);

	public int updateWithImage(WebsiteCaseAlbumT info, StreamVO streamVO,Map<String,Object> iconMap);

}
