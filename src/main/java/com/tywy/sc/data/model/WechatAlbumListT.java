package com.tywy.sc.data.model;

import java.io.Serializable;
import java.util.Date;

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
	private Date effectDate; // 微信素材失效时间（创建时间+3）
	private java.lang.String serialNumber; // 编号
	private java.lang.String description; // 相册描述
	private Date createDate; // 创建时间
	private java.lang.String createUser; // 创建者
	private Date updateDate; // 修改时间
	private java.lang.String updateUser; // 修改者
	private java.lang.String isDelete; // 是否删除(1-是，0-否）
	private java.lang.String urlPath; // 图片路径

	private String effectDateStr;
	private String createDateStr;
	private String updateDateStr;
	private String userid;
	private SystemPictureInfo systemPictureInfo;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getParentid() {
		return parentid;
	}

	public void setParentid(java.lang.String parentid) {
		this.parentid = parentid;
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

	public java.lang.String getMediaId() {
		return mediaId;
	}

	public void setMediaId(java.lang.String mediaId) {
		this.mediaId = mediaId;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public java.lang.String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(java.lang.String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.lang.String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(java.lang.String updateUser) {
		this.updateUser = updateUser;
	}

	public java.lang.String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}

	public java.lang.String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(java.lang.String urlPath) {
		this.urlPath = urlPath;
	}

	public String getEffectDateStr() {
		return effectDateStr;
	}

	public void setEffectDateStr(String effectDateStr) {
		this.effectDateStr = effectDateStr;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}

	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}