package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_category_t实体表()
 * @author lipeng
 * @date 2017-02-12 00:25:48
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteCategoryT extends BaseEntity implements Serializable {
	private java.lang.String id; // 主键
	private java.lang.String code; // 类型代码
	private java.lang.String categoryName; // 类型名称
	private java.lang.Integer status; // 状态（1-启用，0-禁用）
	private java.lang.Integer orderList; // 排序
	private java.util.Date createDate; // 创建时间
	private java.lang.Integer isDelete; // 是否删除（1-是，0-否）
	private java.lang.String imgUuid; // 图片id
	private java.lang.String description; // 描述
	
	private String createDateStr;
	private SystemPictureInfo systemPictureInfo;
	
	/**
     * 获取主键属性
     *
     * @return id
     */
	public java.lang.String getId() {
		return id;
	}
	
	/**
	 * 设置主键属性
	 *
	 * @param id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	/**
     * 获取类型代码属性
     *
     * @return code
     */
	public java.lang.String getCode() {
		return code;
	}
	
	/**
	 * 设置类型代码属性
	 *
	 * @param code
	 */
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	
	public java.lang.String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(java.lang.String categoryName) {
		this.categoryName = categoryName;
	}

	/**
     * 获取状态（1-启用，0-禁用）属性
     *
     * @return status
     */
	public java.lang.Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置状态（1-启用，0-禁用）属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
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
     * 获取是否删除（1-是，0-否）属性
     *
     * @return isDelete
     */
	public java.lang.Integer getIsDelete() {
		return isDelete;
	}
	
	/**
	 * 设置是否删除（1-是，0-否）属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	/**
     * 获取图片id属性
     *
     * @return imgUuid
     */
	public java.lang.String getImgUuid() {
		return imgUuid;
	}
	
	/**
	 * 设置图片id属性
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
        sb.append("WebsiteCategoryT");
        sb.append("{id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(categoryName);
        sb.append(", status=").append(status);
        sb.append(", orderList=").append(orderList);
        sb.append(", createDate=").append(createDate);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", imgUuid=").append(imgUuid);
        sb.append(", description=").append(description);
		sb.append('}');
        return sb.toString();
    }
    
}