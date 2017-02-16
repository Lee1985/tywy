package com.tywy.sc.services;

import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.utils.stream.util.StreamVO;
import com.tywy.sc.base.service.BaseService;

public interface WechatAlbumListTService extends BaseService<WechatAlbumListT>{

	public int insertWithImage(WechatAlbumListT info, StreamVO streamVO);

	public int updateWithImage(WechatAlbumListT info, StreamVO streamVO);

}
