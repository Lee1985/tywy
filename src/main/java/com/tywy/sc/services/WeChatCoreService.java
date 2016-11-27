package com.tywy.sc.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.wechat.ReceiveXmlVO;

public interface WeChatCoreService extends BaseService<ReceiveXmlVO> {

	String processRequest(HttpServletRequest request) throws IOException;

	String searchRequest(HttpServletRequest request) throws IOException;

	String contactRequest(HttpServletRequest request) throws IOException;

}