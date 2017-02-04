package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatPubReplyTDao;
import com.tywy.sc.data.model.WechatPubReplyT;
import org.springframework.stereotype.Component;

/**
 * @author mew
 */
@Component
public class WechatPubReplyTDaoImpl extends BaseDaoImpl<WechatPubReplyT> implements WechatPubReplyTDao {
    public WechatPubReplyTDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}