package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_case_album_t实体表()
 * @author lipeng
 * @date 2017-02-16 03:29:32
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteCaseAlbumT extends BaseEntity implements Serializable {
	private java.lang.String id; // 主键ID
	private java.lang.String imgUuid; // 图片ID
	private java.lang.String serialNumber; // 图片编号
	private java.lang.String imageName; // 图片名称
	private java.lang.String description; // 描述
	private java.lang.String caseId; // 品牌ID
	private java.util.Date createDate; // 创建时间
	private java.lang.String createUser; // 创建用户
	private java.util.Date updateDate; // 修改时间
	private java.lang.String updateUser; // 修改用户
	private java.lang.String status; // 状态
	private java.lang.String isDelete; // 删除标记
	
	private SystemPictureInfo systemPictureInfo;
	/**
     * 获取主键ID属性
     *
     * @return id
     */
	public java.lang.String getId() {
		return id;
	}
	
	/**
	 * 设置主键ID属性
	 *
	 * @param id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	/**
     * 获取图片ID属性
     *
     * @return imgUuid
     */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}
	
	/**
	 * 设置图片ID属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
	}
	
	/**
     * 获取图片编号属性
     *
     * @return serialNumber
     */
	public java.lang.String getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * 设置图片编号属性
	 *
	 * @param serialNumber
	 */
	public void setSerialNumber(java.lang.String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	/**
     * 获取图片名称属性
     *
     * @return imageName
     */
	public java.lang.String getImageName() {
		return imageName;
	}
	
	/**
	 * 设置图片名称属性
	 *
	 * @param imageName
	 */
	public void setImageName(java.lang.String imageName) {
		this.imageName = imageName;
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
     * 获取品牌ID属性
     *
     * @return caseId
     */
	public java.lang.String getCaseId() {
		return caseId;
	}
	
	/**
	 * 设置品牌ID属性
	 *
	 * @param caseId
	 */
	public void setCaseId(java.lang.String caseId) {
		this.caseId = caseId;
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

	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}

	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteCaseAlbumT");
        sb.append("{id=").append(id);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", imageName=").append(imageName);
        sb.append(", description=").append(description);
        sb.append(", caseId=").append(caseId);
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