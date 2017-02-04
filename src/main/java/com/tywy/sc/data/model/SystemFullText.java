package com.tywy.sc.data.model;

import java.io.Serializable;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * system_full_text实体表()
 *
 * @author William
 * @date 2016-11-22 11:11:20
 * @project
 */
@SuppressWarnings("serial")
public class SystemFullText extends BaseEntity implements Serializable {
    private java.lang.String id; // 主键
    private java.lang.Integer type; // 类别1注册协议2关于软件3关于我们4帮助
    private java.lang.String title; // 标题
    private java.lang.String msgContent; // 内容

    /**
     * 获取属性
     *
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * 设置属性
     *
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    /**
     * 获取属性
     *
     * @return type
     */
    public java.lang.Integer getType() {
        return type;
    }

    /**
     * 设置属性
     *
     * @param type
     */
    public void setType(java.lang.Integer type) {
        this.type = type;
    }

    /**
     * 获取属性
     *
     * @return msgContent
     */
    public java.lang.String getMsgContent() {
        return msgContent;
    }

    /**
     * 设置属性
     *
     * @param msgContent
     */
    public void setMsgContent(java.lang.String msgContent) {
        this.msgContent = msgContent;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

}