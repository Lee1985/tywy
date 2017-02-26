package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_brand_t实体表()
 * @author lipeng
 * @date 2017-02-13 03:54:25
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteBrandT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String brandName; // 封面ID
	private java.lang.String engText; // 
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 照片
	private java.lang.String content; // 相册描述
	private java.lang.String status; // 
	private java.lang.String isDelete; // 
	private java.util.Date createDate; // 创建时间
	private java.lang.String createUser; // 创建者
	
	private String createDateStr;
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
     * 获取封面ID属性
     *
     * @return brandName
     */
	public java.lang.String getBrandName() {
		return brandName;
	}
	
	/**
	 * 设置封面ID属性
	 *
	 * @param brandName
	 */
	public void setBrandName(java.lang.String brandName) {
		this.brandName = brandName;
	}
	
	/**
     * 获取属性
     *
     * @return engText
     */
	public java.lang.String getEngText() {
		return engText;
	}
	
	/**
	 * 设置属性
	 *
	 * @param engText
	 */
	public void setEngText(java.lang.String engText) {
		this.engText = engText;
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
     * 获取相册描述属性
     *
     * @return content
     */
	public java.lang.String getContent() {
		return content;
	}
	
	/**
	 * 设置相册描述属性
	 *
	 * @param content
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
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

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteBrandT");
        sb.append("{id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", engText=").append(engText);
        sb.append(", orderList=").append(orderList);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
		sb.append('}');
        return sb.toString();
    }
    
}