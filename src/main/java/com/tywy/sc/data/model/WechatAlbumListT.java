package com.tywy.sc.data.model;

import java.io.Serializable;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_album_list_t实体表()
 * 
 * @author William
 * @date 2017-01-25 10:23:05
 * @project
 */
@SuppressWarnings("serial")
public class WechatAlbumListT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.String parentid; // 封面ID
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 照片
	private java.lang.String mediaId; // 微信素材id
	private java.lang.String serialNumber; // 编号
	private java.lang.String description; // 相册描述
	private String createDate; // 创建时间
	private java.lang.String createUser; // 创建者
	private String updateDate; // 修改时间
	private java.lang.String updateUser; // 修改者
	private java.lang.Integer isDelete; // 是否删除(1-是，0-否）
	private java.lang.String urlPath; // 图片路径

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
	 * 获取封面ID属性
	 *
	 * @return parentid
	 */
	public java.lang.String getParentid() {
		return parentid;
	}

	/**
	 * 设置封面ID属性
	 *
	 * @param parentid
	 */
	public void setParentid(java.lang.String parentid) {
		this.parentid = parentid;
	}

	/**
	 * 获取排序属性
	 *
	 * @return orderList
	 */
	public java.lang.Integer getOrderList() {
		return orderList;
	}

	/**
	 * 设置排序属性
	 *
	 * @param orderList
	 */
	public void setOrderList(java.lang.Integer orderList) {
		this.orderList = orderList;
	}

	/**
	 * 获取照片属性
	 *
	 * @return imgUuid
	 */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}

	/**
	 * 设置照片属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
	}

	/**
	 * 获取微信素材id属性
	 *
	 * @return mediaId
	 */
	public java.lang.String getMediaId() {
		return mediaId;
	}

	/**
	 * 设置微信素材id属性
	 *
	 * @param mediaId
	 */
	public void setMediaId(java.lang.String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 获取编号属性
	 *
	 * @return serialNumber
	 */
	public java.lang.String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * 设置编号属性
	 *
	 * @param serialNumber
	 */
	public void setSerialNumber(java.lang.String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * 获取相册描述属性
	 *
	 * @return description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * 设置相册描述属性
	 *
	 * @param description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
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
	 * 获取创建者属性
	 *
	 * @return createUser
	 */
	public java.lang.String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置创建者属性
	 *
	 * @param createUser
	 */
	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取修改时间属性
	 *
	 * @return updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置修改时间属性
	 *
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取修改者属性
	 *
	 * @return updateUser
	 */
	public java.lang.String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 设置修改者属性
	 *
	 * @param updateUser
	 */
	public void setUpdateUser(java.lang.String updateUser) {
		this.updateUser = updateUser;
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