package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteCaseAlbumT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteCaseAlbumTService extends BaseService<WebsiteCaseAlbumT>{

	public int insertWithImage(WebsiteCaseAlbumT info, StreamVO streamVO);

	public int updateWithImage(WebsiteCaseAlbumT info, StreamVO streamVO);

}
