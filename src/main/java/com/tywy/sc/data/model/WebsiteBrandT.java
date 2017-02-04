package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_brand_t实体表()
 * @author lipeng
 * @date 2016-12-02 10:50:20
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteBrandT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String name; // 品牌名称
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 品牌封面
	private java.lang.String serial_number; // 编号
	private java.lang.String description; // 相册描述
	private java.util.Date createDate; // 创建时间
	private java.lang.String createUser; // 创建者
	private java.util.Date updateDate; // 
	private java.lang.String updateUser; // 
	private java.lang.String status; // 
	private java.lang.String isDelete; // 
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
     * 获取品牌名称属性
     *
     * @return name
     */
	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * 设置品牌名称属性
	 *
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
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
     * 获取品牌封面属性
     *
     * @return imgUuid
     */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}
	
	/**
	 * 设置品牌封面属性
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
     * 获取属性
     *
     * @return updateDate
     */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置属性
	 *
	 * @param updateDate
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
     * 获取属性
     *
     * @return updateUser
     */
	public java.lang.String getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * 设置属性
	 *
	 * @param updateUser
	 */
	public void setUpdateUser(java.lang.String updateUser) {
		this.updateUser = updateUser;
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
	

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteBrandT");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", orderList=").append(orderList);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", serial_number=").append(serial_number);
        sb.append(", description=").append(description);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
		sb.append('}');
        return sb.toString();
    }
    
}