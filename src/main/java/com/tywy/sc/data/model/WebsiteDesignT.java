package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_design_t实体表()
 * @author lipeng
 * @date 2017-02-15 17:15:36
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteDesignT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String designName; // 设计名称
	private java.lang.String parentid; // 封面ID
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 照片
	private java.lang.String serial_number; // 编号
	private java.lang.String description; // 相册描述
	private java.util.Date createDate; // 创建时间
	private java.lang.String createUser; // 创建者
	private java.lang.String status; // 状态
	private java.lang.String isDelete; // 删除状态
	
	private SystemPictureInfo systemPictureInfo;
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
     * 获取设计名称属性
     *
     * @return designName
     */
	public java.lang.String getDesignName() {
		return designName;
	}
	
	/**
	 * 设置设计名称属性
	 *
	 * @param designName
	 */
	public void setDesignName(java.lang.String designName) {
		this.designName = designName;
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
	
	/**
     * 获取状态属性
     *
     * @return status
     */
	public java.lang.String getStatus() {
		return status;
	}
	
	/**
	 * 设置状态属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
     * 获取删除状态属性
     *
     * @return isDelete
     */
	public java.lang.String getIsDelete() {
		return isDelete;
	}
	
	/**
	 * 设置删除状态属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}

	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}
	
	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteDesignT");
        sb.append("{id=").append(id);
        sb.append(", designName=").append(designName);
        sb.append(", parentid=").append(parentid);
        sb.append(", orderList=").append(orderList);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", serial_number=").append(serial_number);
        sb.append(", description=").append(description);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
		sb.append('}');
        return sb.toString();
    }
    
}