package com.tywy.sc.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.SystemPictureInfo;

public interface SystemPictureInfoService extends BaseService<SystemPictureInfo>{
	
	/**
	 * 新增文件
	 * @param file
	 * @param filePath
	 * @return
	 */
	public SystemPictureInfo insertFileInfo(MultipartFile file, String filePath, String webPath);

	/**
	 * 根据uuid查询文件信息
	 * @param uuid
	 * @return
	 */
	public SystemPictureInfo selectEntityByUuid(String uuid);
	/**
	 * 根据多个uuid查询文件列表
	 * @param videoIdList
	 * @return
	 */
	public List<SystemPictureInfo> selectByUuids(List<String> uuidList);

}
