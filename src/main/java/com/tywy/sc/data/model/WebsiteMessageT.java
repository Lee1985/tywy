package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_message_t实体表()
 * 
 * @author Liuheli
 * @date 2017-02-14 23:08:23
 * @project
 */
@SuppressWarnings("serial")
public class WebsiteMessageT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.String name; // 姓名
	private java.lang.String mobile; // 手机
	private java.lang.String content; // 留言
	private String createDate; // 创建时间
	private java.lang.Integer isDelete; // 是否删除0否1是

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
	 * 获取姓名属性
	 *
	 * @return name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * 设置姓名属性
	 *
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 获取手机属性
	 *
	 * @return mobile
	 */
	public java.lang.String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机属性
	 *
	 * @param mobile
	 */
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取留言属性
	 *
	 * @return content
	 */
	public java.lang.String getContent() {
		return content;
	}

	/**
	 * 设置留言属性
	 *
	 * @param content
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取创建时间属性
	 *
	 * @return createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建时间属性
	 *
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取是否删除0否1是属性
	 *
	 * @return isDelete
	 */
	public java.lang.Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * 设置是否删除0否1是属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("WebsiteMessageT");
		sb.append("{id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", mobile=").append(mobile);
		sb.append(", content=").append(content);
		sb.append(", createDate=").append(createDate);
		sb.append(", isDelete=").append(isDelete);
		sb.append('}');
		return sb.toString();
	}

}