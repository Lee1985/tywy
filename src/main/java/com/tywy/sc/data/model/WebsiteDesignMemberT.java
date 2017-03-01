package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_design_member_t实体表()
 * @author lipeng
 * @date 2017-02-28 16:21:37
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteDesignMemberT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String imgUuid; // 
	private java.lang.Integer orderList; // 
	private java.lang.String status; // 
	private java.lang.String isDelete; // 
	private java.lang.String createUser; // 
	private java.util.Date createDate; // 
	private java.lang.String description; // 
	
	private SystemPictureInfo systemPictureInfo;
	private String createDateStr;
	
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
     * @return imgUuid
     */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}
	
	/**
	 * 设置属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
	}
	
	/**
     * 获取属性
     *
     * @return orderList
     */
	public java.lang.Integer getOrderList() {
		return orderList;
	}
	
	/**
	 * 设置属性
	 *
	 * @param orderList
	 */
	public void setOrderList(java.lang.Integer orderList) {
		this.orderList = orderList;
	}
	
	/**
     * 获取属性
     *
     * @return status
     */
	public java.lang.String getStatus() {
		return status;
	}
	
	/**
	 * 设置属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
     * 获取属性
     *
     * @return isDelete
     */
	public java.lang.String getIsDelete() {
		return isDelete;
	}
	
	/**
	 * 设置属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}
	
	/**
     * 获取属性
     *
     * @return createUser
     */
	public java.lang.String getCreateUser() {
		return createUser;
	}
	
	/**
	 * 设置属性
	 *
	 * @param createUser
	 */
	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}
	
	/**
     * 获取属性
     *
     * @return createDate
     */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置属性
	 *
	 * @param createDate
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	/**
     * 获取属性
     *
     * @return description
     */
	public java.lang.String getDescription() {
		return description;
	}
	
	/**
	 * 设置属性
	 *
	 * @param description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}

	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

	public String getCreateDateStr() {
		createDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createDate);
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteDesignMemberT");
        sb.append("{id=").append(id);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", orderList=").append(orderList);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", description=").append(description);
		sb.append('}');
        return sb.toString();
    }
    
}