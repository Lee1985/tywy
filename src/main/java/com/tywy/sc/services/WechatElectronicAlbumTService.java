package com.tywy.sc.services;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.utils.stream.util.StreamVO;

public interface WechatElectronicAlbumTService extends BaseService<WechatElectronicAlbumT> {

	public int insertWithImage(WechatElectronicAlbumT info, StreamVO streamVO);

	public int updateWithImage(WechatElectronicAlbumT info, StreamVO streamVO);

}
