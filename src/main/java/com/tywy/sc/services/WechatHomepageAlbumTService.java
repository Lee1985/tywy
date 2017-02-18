package com.tywy.sc.services;

import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WechatHomepageAlbumTService extends BaseService<WechatHomepageAlbumT>{

	int insertWithImage(WechatHomepageAlbumT info, StreamVO streamVO);

	int updateWithImage(WechatHomepageAlbumT info, StreamVO streamVO);

}
