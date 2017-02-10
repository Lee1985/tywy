package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_homepage_case_t实体表()
 * @author lipeng
 * @date 2017-02-10 14:58:24
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteHomepageCaseT extends BaseEntity implements Serializable {
	private java.lang.String id; // 主键id
	private java.lang.String caseName; // 案例名称
	private java.lang.String imgUuid; // 图片uuid
	private java.lang.String engText; // 英文标识
	private java.lang.String description; // 描述
	private java.lang.Integer orderList; // 序号
	private java.lang.String status; // 状态
	private java.lang.String isDelete; // 删除标记
	private java.lang.String targetUrl; // 指定的地址
	private java.lang.String createUser; // 创建用户
	private java.util.Date createDate; // 创建时间
	private java.lang.String updateUser; // 修改用户
	private java.util.Date updateDate; // 修改时间
	
	private SystemPictureInfo systemPictureInfo;
	private String createDateStr;
	/**
     * 获取主键id属性
     *
     * @return id
     */
	public java.lang.String getId() {
		return id;
	}
	
	/**
	 * 设置主键id属性
	 *
	 * @param id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	/**
     * 获取案例名称属性
     *
     * @return caseName
     */
	public java.lang.String getCaseName() {
		return caseName;
	}
	
	/**
	 * 设置案例名称属性
	 *
	 * @param caseName
	 */
	public void setCaseName(java.lang.String caseName) {
		this.caseName = caseName;
	}
	
	/**
     * 获取图片uuid属性
     *
     * @return imgUuid
     */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}
	
	/**
	 * 设置图片uuid属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
	}
	
	/**
     * 获取英文标识属性
     *
     * @return engText
     */
	public java.lang.String getEngText() {
		return engText;
	}
	
	/**
	 * 设置英文标识属性
	 *
	 * @param engText
	 */
	public void setEngText(java.lang.String engText) {
		this.engText = engText;
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
     * 获取删除标记属性
     *
     * @return isDelete
     */
	public java.lang.String getIsDelete() {
		return isDelete;
	}
	
	/**
	 * 设置删除标记属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}
	
	/**
     * 获取指定的地址属性
     *
     * @return targetUrl
     */
	public java.lang.String getTargetUrl() {
		return targetUrl;
	}
	
	/**
	 * 设置指定的地址属性
	 *
	 * @param targetUrl
	 */
	public void setTargetUrl(java.lang.String targetUrl) {
		this.targetUrl = targetUrl;
	}
	
	/**
     * 获取创建用户属性
     *
     * @return createUser
     */
	public java.lang.String getCreateUser() {
		return createUser;
	}
	
	/**
	 * 设置创建用户属性
	 *
	 * @param createUser
	 */
	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
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
     * 获取修改用户属性
     *
     * @return updateUser
     */
	public java.lang.String getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * 设置修改用户属性
	 *
	 * @param updateUser
	 */
	public void setUpdateUser(java.lang.String updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
     * 获取修改时间属性
     *
     * @return updateDate
     */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置修改时间属性
	 *
	 * @param updateDate
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
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
        sb.append("WebsiteHomepageCaseT");
        sb.append("{id=").append(id);
        sb.append(", caseName=").append(caseName);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", engText=").append(engText);
        sb.append(", description=").append(description);
        sb.append(", orderList=").append(orderList);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", targetUrl=").append(targetUrl);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
		sb.append('}');
        return sb.toString();
    }
    
}