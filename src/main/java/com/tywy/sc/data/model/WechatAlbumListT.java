package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_album_list_t实体表()
 * 
 * @author William
 * @date 2016-11-27 16:56:19
 * @project
 */
@SuppressWarnings("serial")
public class WechatAlbumListT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.String parentid; // 封面ID
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 照片
	private java.lang.String mediaId; // 微信素材id
	private java.lang.String serial_number; // 编号
	private java.lang.String description; // 相册描述
	private java.util.Date createDate; // 创建时间
	private java.lang.String createUser; // 创建者

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
	 * 获取编号属性
	 *
	 * @return serial_number
	 */
	public java.lang.String getSerialNumber() {
		return serial_number;
	}

	/**
	 * 设置编号属性
	 *
	 * @param serial_number
	 */
	public void setSerialNumber(java.lang.String serial_number) {
		this.serial_number = serial_number;
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
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建时间属性
	 *
	 * @param createDate
	 */
	public void setCreateDate(java.util.Date createDate) {
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

	public java.lang.String getMediaId() {
		return mediaId;
	}

	public void setMediaId(java.lang.String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "WechatAlbumListT [id=" + id + ", parentid=" + parentid + ", orderList=" + orderList + ", imgUuid="
				+ imgUuid + ", mediaId=" + mediaId + ", serial_number=" + serial_number + ", description=" + description
				+ ", createDate=" + createDate + ", createUser=" + createUser + "]";
	}
	

}