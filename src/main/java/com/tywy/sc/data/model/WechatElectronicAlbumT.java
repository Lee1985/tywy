package com.tywy.sc.data.model;

import java.io.Serializable;
import java.util.Date;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_electronic_album_t实体表()
 *
 * @author William
 * @date 2016-11-27 16:56:19
 * @project
 */
@SuppressWarnings("serial")
public class WechatElectronicAlbumT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 相册封面
	private java.lang.String albumName; // 相册名称
	private java.lang.String description; // 相册描述
	private Date createDate; // 创建时间
	private Date updateDate; // 修改时间
	private java.lang.String createUser; // 创建者
	private java.lang.String updateUser; // 修改者
	private java.lang.String isDelete; // 是否删除(1-是，0-否）
	private int count; // 照片数量
	private String status;
	
	private SystemPictureInfo systemPictureInfo;
	private String createDateStr;
	private String updateDateStr;

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
	 * 获取相册封面属性
	 *
	 * @return imgUuid
	 */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}

	/**
	 * 设置相册封面属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
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
	
	public java.lang.String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(java.lang.String albumName) {
		this.albumName = albumName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public java.lang.String getIsDelete() {
		return isDelete;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("WechatElectronicAlbumT");
		sb.append("{id=").append(id);
		sb.append(", orderList=").append(orderList);
		sb.append(", imgUuid=").append(imgUuid);
		sb.append(", albumName=").append(albumName);
		sb.append(", description=").append(description);
		sb.append(", createDate=").append(createDate);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", createUser=").append(createUser);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", isDelete=").append(isDelete);
		sb.append('}');
		return sb.toString();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}

	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

}