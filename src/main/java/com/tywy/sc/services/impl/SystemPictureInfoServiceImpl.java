package com.tywy.sc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.SystemPictureInfoDao;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.services.SystemPictureInfoService;

@Service
public class SystemPictureInfoServiceImpl extends BaseServiceImpl<SystemPictureInfo> implements SystemPictureInfoService {
	
	@Autowired
	private SystemPictureInfoDao systemPictureInfoDao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(systemPictureInfoDao);
	}
	
	@Override
	public SystemPictureInfo selectEntityByUuid(String uuid) {
		return systemPictureInfoDao.selectEntityByUuid(uuid);
	}
	
	@Override
	public SystemPictureInfo insertFileInfo(MultipartFile file, String filePath,String webPath) {
//		FileInfo fileInfo = FileTool.saveFile(file, filePath);
//		String urlPath = webPath + fileInfo.getRealName();
//		SystemPictureInfo systemPicInfo = new SystemPictureInfo();
//		systemPicInfo.setId(UUIDUtil.getUUID());
//		systemPicInfo.setUuid(UUIDUtil.getUUID());
//		systemPicInfo.setUrlPath(urlPath);
//		systemPicInfo.setFsize((int)fileInfo.getFsize());
//		systemPicInfo.setCdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		systemPicInfo.setSuffix(fileInfo.getSuffix());
//		int result = systemPictureInfoDao.insert(systemPicInfo);
//		if(result > 0){
//			return systemPicInfo;
//		}else{
//			return null;
//		}
		return null;
	}

	@Override
	public List<SystemPictureInfo> selectByUuids(List<String> uuidList) {
		return systemPictureInfoDao.selectByUuids(uuidList);
	}

}