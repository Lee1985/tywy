package com.tywy.sc.data.model;

import java.io.Serializable;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_pub_reply_t实体表()
 * 
 * @author William
 * @date 2016-11-27 14:28:36
 * @project
 */
@SuppressWarnings("serial")
public class WechatPubReplyT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.Integer type; // 类型（1-首次关注；2-联系我们；3-搜索图片）
	private java.lang.String content; // 内容
	private java.util.Date createDate; // 收藏时间

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
	 * 获取类型（1-首次关注；2-联系我们；3-搜索图片）属性
	 *
	 * @return type
	 */
	public java.lang.Integer getType() {
		return type;
	}

	/**
	 * 设置类型（1-首次关注；2-联系我们；3-搜索图片）属性
	 *
	 * @param type
	 */
	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	/**
	 * 获取内容属性
	 *
	 * @return content
	 */
	public java.lang.String getContent() {
		return content;
	}

	/**
	 * 设置内容属性
	 *
	 * @param content
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取收藏时间属性
	 *
	 * @return createDate
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置收藏时间属性
	 *
	 * @param createDate
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("WechatPubReplyT");
		sb.append("{id=").append(id);
		sb.append(", type=").append(type);
		sb.append(", content=").append(content);
		sb.append(", createDate=").append(createDate);
		sb.append('}');
		return sb.toString();
	}

}