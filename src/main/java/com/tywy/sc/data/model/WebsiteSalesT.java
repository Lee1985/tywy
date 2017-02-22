package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_sales_t实体表()
 * @author lipeng
 * @date 2017-02-21 05:15:37
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteSalesT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String categoryId; // 类别id
	private java.lang.String company; // 公司名称
	private java.lang.String area; // 地址
	private java.lang.String contact; // 联系人
	private java.lang.String mobile; // 手机
	private java.lang.String adress; // 联系地址
	private java.lang.String email; // 邮箱
	private java.lang.String fax; // 传真
	private java.lang.String latitude; // 维度
	private java.lang.String longitude; // 经度
	private java.lang.Integer orderList; // 排序
	private java.lang.String status; // 状态1启用0禁用
	private java.lang.String description; // 描述
	private java.lang.String createUser; // 创建者
	private java.util.Date createDate; // 上传时间
	private java.lang.String isDelete; // 是否删除0否1是
	
	private String categoryName;
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
     * 获取公司名称属性
     *
     * @return company
     */
	public java.lang.String getCompany() {
		return company;
	}
	
	/**
	 * 设置公司名称属性
	 *
	 * @param company
	 */
	public void setCompany(java.lang.String company) {
		this.company = company;
	}
	
	/**
     * 获取地址属性
     *
     * @return area
     */
	public java.lang.String getArea() {
		return area;
	}
	
	/**
	 * 设置地址属性
	 *
	 * @param area
	 */
	public void setArea(java.lang.String area) {
		this.area = area;
	}
	
	/**
     * 获取联系人属性
     *
     * @return contact
     */
	public java.lang.String getContact() {
		return contact;
	}
	
	/**
	 * 设置联系人属性
	 *
	 * @param contact
	 */
	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}
	
	/**
     * 获取手机属性
     *
     * @return mobile
     */
	public java.lang.String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置手机属性
	 *
	 * @param mobile
	 */
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	
	/**
     * 获取联系地址属性
     *
     * @return adress
     */
	public java.lang.String getAdress() {
		return adress;
	}
	
	/**
	 * 设置联系地址属性
	 *
	 * @param adress
	 */
	public void setAdress(java.lang.String adress) {
		this.adress = adress;
	}
	
	/**
     * 获取邮箱属性
     *
     * @return email
     */
	public java.lang.String getEmail() {
		return email;
	}
	
	/**
	 * 设置邮箱属性
	 *
	 * @param email
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	/**
     * 获取传真属性
     *
     * @return fax
     */
	public java.lang.String getFax() {
		return fax;
	}
	
	/**
	 * 设置传真属性
	 *
	 * @param fax
	 */
	public void setFax(java.lang.String fax) {
		this.fax = fax;
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
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public java.lang.String getLatitude() {
		return latitude;
	}

	public void setLatitude(java.lang.String latitude) {
		this.latitude = latitude;
	}

	public java.lang.String getLongitude() {
		return longitude;
	}

	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteSalesT");
        sb.append("{id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", company=").append(company);
        sb.append(", area=").append(area);
        sb.append(", contact=").append(contact);
        sb.append(", mobile=").append(mobile);
        sb.append(", adress=").append(adress);
        sb.append(", email=").append(email);
        sb.append(", fax=").append(fax);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
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