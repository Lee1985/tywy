package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_homepage_album_t实体表()
 * 
 * @author Liuheli
 * @date 2017-01-23 17:12:42
 * @project
 */
@SuppressWarnings("serial")
public class WechatHomepageAlbumT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 轮播图uid
	private java.lang.String name; // 名称
	private java.lang.String description; // 相册描述
	private java.util.Date createDate; // 创建时间
	private java.lang.String createUser; // 创建者
	private String updateDate; // 修改时间
	private java.lang.String updateUser; // 修改者
	private java.lang.Integer isDelete; // 是否删除(1-是，0-否）
	private String createDateStr;

	private SystemPictureInfo systemPictureInfo;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.Integer getOrderList() {
		return orderList;
	}

	public void setOrderList(java.lang.Integer orderList) {
		this.orderList = orderList;
	}

	public java.lang.String getImgUuid() {
		return imgUuid;
	}

	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public java.lang.String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(java.lang.String updateUser) {
		this.updateUser = updateUser;
	}

	public java.lang.Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(java.lang.Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateDateStr() {
		createDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createDate);
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}

	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

}