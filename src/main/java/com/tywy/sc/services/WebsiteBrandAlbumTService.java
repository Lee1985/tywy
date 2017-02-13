package com.tywy.sc.services;

import com.tywy.sc.data.model.WebsiteBrandAlbumT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WebsiteBrandAlbumTService extends BaseService<WebsiteBrandAlbumT>{

	public int insertWithImage(WebsiteBrandAlbumT info, StreamVO streamVO);

	public int updateWithImage(WebsiteBrandAlbumT info, StreamVO streamVO);

}
