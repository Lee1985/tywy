package com.tywy.sc.data.model;

import java.io.Serializable;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_album_rel_t实体表()
 * 
 * @author Liuheli
 * @date 2017-01-25 19:03:30
 * @project
 */
@SuppressWarnings("serial")
public class WechatAlbumRelT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.String parentid; // 父照片id
	private java.lang.String imgUuid; // 子照片id
	private java.lang.String description; // 描述
	private java.lang.Integer orderList; // 序号
	private java.lang.String createDate; // 创建时间
	private java.lang.Integer isDelete; // 是否删除(1-是，0-否）
	private java.lang.String urlPath; // 图片地址

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
	 * 获取父照片id属性
	 *
	 * @return parentid
	 */
	public java.lang.String getParentid() {
		return parentid;
	}

	/**
	 * 设置父照片id属性
	 *
	 * @param parentid
	 */
	public void setParentid(java.lang.String parentid) {
		this.parentid = parentid;
	}

	/**
	 * 获取子照片id属性
	 *
	 * @return imgUuid
	 */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}

	/**
	 * 设置子照片id属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
	}

	/**
	 * 获取描述属性
	 *
	 * @return description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * 设置描述属性
	 *
	 * @param description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * 获取序号属性
	 *
	 * @return orderList
	 */
	public java.lang.Integer getOrderList() {
		return orderList;
	}

	/**
	 * 设置序号属性
	 *
	 * @param orderList
	 */
	public void setOrderList(java.lang.Integer orderList) {
		this.orderList = orderList;
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
	 * 获取是否删除(1-是，0-否）属性
	 *
	 * @return isDelete
	 */
	public java.lang.Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * 设置是否删除(1-是，0-否）属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.Integer isDelete) {
		this.isDelete = isDelete;
	}

	public java.lang.String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(java.lang.String urlPath) {
		this.urlPath = urlPath;
	}

}