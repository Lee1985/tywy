package com.tywy.sc.services;

import com.tywy.sc.base.service.BaseService;
import com.tywy.sc.data.model.wechat.ReceiveXmlVO;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface WeChatCoreService extends BaseService<ReceiveXmlVO> {

    String processRequest(HttpServletRequest request) throws IOException;

}