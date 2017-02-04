package com.tywy.sc.data.dao.impl;

import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.WechatElectronicAlbumTDao;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import org.springframework.stereotype.Component;

/**
 * @author mew
 */
@Component
public class WechatElectronicAlbumTDaoImpl extends BaseDaoImpl<WechatElectronicAlbumT> implements WechatElectronicAlbumTDao {
    public WechatElectronicAlbumTDaoImpl() {
        setSql_name_space(sqlNameSpace);
    }
}