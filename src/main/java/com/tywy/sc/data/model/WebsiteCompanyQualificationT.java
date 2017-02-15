package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_company_qualification_t实体表()
 * @author lipeng
 * @date 2017-02-14 19:10:05
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteCompanyQualificationT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String imgUuid; // 
	private java.lang.String descName; // 
	private java.lang.String status; // 
	private java.lang.String isDelete; // 
	private java.lang.String createUser; // 
	private java.util.Date createDate; // 
	
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
     * @return descName
     */
	public java.lang.String getDescName() {
		return descName;
	}
	
	/**
	 * 设置属性
	 *
	 * @param descName
	 */
	public void setDescName(java.lang.String descName) {
		this.descName = descName;
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
	
	public SystemPictureInfo getSystemPictureInfo() {
		return systemPictureInfo;
	}

	public void setSystemPictureInfo(SystemPictureInfo systemPictureInfo) {
		this.systemPictureInfo = systemPictureInfo;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteCompanyQualificationT");
        sb.append("{id=").append(id);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", descName=").append(descName);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
		sb.append('}');
        return sb.toString();
    }
    
}