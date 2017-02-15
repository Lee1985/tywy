package com.tywy.sc.data.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_introduction_t实体表()
 * @author lipeng
 * @date 2017-02-14 18:34:15
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteIntroductionT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String categoryId; // 类别id
	private java.lang.String introduceName; // 关于标题
	private java.lang.Integer orderList; // 排序
	private java.lang.String status; // 状态1启用0禁用
	private java.lang.String description; // 描述
	private java.lang.String createUser; // 创建者
	private java.util.Date createDate; // 上传时间
	private java.lang.String isDelete; // 是否删除0否1是
	
	private String createDateStr;
	private String isHomePage;
	
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
     * 获取类别id属性
     *
     * @return categoryId
     */
	public java.lang.String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置类别id属性
	 *
	 * @param categoryId
	 */
	public void setCategoryId(java.lang.String categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
     * 获取关于标题属性
     *
     * @return introduceName
     */
	public java.lang.String getIntroduceName() {
		return introduceName;
	}
	
	/**
	 * 设置关于标题属性
	 *
	 * @param introduceName
	 */
	public void setIntroduceName(java.lang.String introduceName) {
		this.introduceName = introduceName;
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
     * 获取状态1启用0禁用属性
     *
     * @return status
     */
	public java.lang.String getStatus() {
		return status;
	}
	
	/**
	 * 设置状态1启用0禁用属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
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
     * 获取是否删除0否1是属性
     *
     * @return isDelete
     */
	public java.lang.String getIsDelete() {
		return isDelete;
	}
	
	/**
	 * 设置是否删除0否1是属性
	 *
	 * @param isDelete
	 */
	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}
	
	public String getCreateDateStr() {
		createDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createDate);
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getIsHomePage() {
		return isHomePage;
	}

	public void setIsHomePage(String isHomePage) {
		this.isHomePage = isHomePage;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteIntroductionT");
        sb.append("{id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", introduceName=").append(introduceName);
        sb.append(", orderList=").append(orderList);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", isDelete=").append(isDelete);
		sb.append('}');
        return sb.toString();
    }
    
}