package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatUserInfoTDao;
import com.tywy.sc.data.model.WechatUserInfoT;
import org.springframework.stereotype.Component;

@Component
public class WechatUserInfoTDaoImpl extends BaseDaoImpl<WechatUserInfoT> implements WechatUserInfoTDao {
    public WechatUserInfoTDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}