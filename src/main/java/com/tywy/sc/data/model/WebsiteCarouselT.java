package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_carousel_t实体表()
 * @author lipeng
 * @date 2017-01-18 00:44:40
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteCarouselT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.Integer type; // 类型（1-首页，2-关于）
	private java.lang.Integer orderList; // 排序
	private java.lang.String imgUuid; // 图片
	private java.lang.String description; // 描述
	private java.lang.String createUser; // 创建者
	private java.util.Date createDate; // 上传时间
	private java.lang.Integer status; // 状态1启用0禁用
	private java.lang.Integer isDelete; // 是否删除0否1是
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
     * 获取类型（1-首页，2-关于）属性
     *
     * @return type
     */
	public java.lang.Integer getType() {
		return type;
	}
	
	/**
	 * 设置类型（1-首页，2-关于）属性
	 *
	 * @param type
	 */
	public void setType(java.lang.Integer type) {
		this.type = type;
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
     * 获取图片属性
     *
     * @return imgUuid
     */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}
	
	/**
	 * 设置图片属性
	 *
	 * @param imgUuid
	 */
	public void setImgUuid(java.lang.String imgUuid) {
		this.imgUuid = imgUuid;
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
     * 获取上传时间属性
     *
     * @return createDate
     */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置上传时间属性
	 *
	 * @param createDate
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	/**
     * 获取状态1启用0禁用属性
     *
     * @return status
     */
	public java.lang.Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置状态1启用0禁用属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	
	/**
     * 获取是否删除0否1是属性
     *
     * @return isDelete
     */
	public java.lang.Integer getIsDelete() {
		return isDelete;
	}
	
	/**
	 * 设置是否删除0否1是属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.Integer isDelete) {
		this.isDelete = isDelete;
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
        sb.append("WebsiteCarouselT");
        sb.append("{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", orderList=").append(orderList);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", description=").append(description);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
		sb.append('}');
        return sb.toString();
    }
    
}