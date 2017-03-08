package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * website_homepage_sales_t实体表()
 * @author lipeng
 * @date 2017-03-07 15:58:14
 * @project 
 */
 @SuppressWarnings("serial")
public class WebsiteHomepageSalesT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String saleName; // 
	private java.lang.String city; // 
	private java.lang.String address; // 
	private java.lang.String email; // 
	private java.lang.String webAddress; // 
	private java.lang.String lat; // 
	private java.lang.String lng; // 
	private java.lang.String status; // 
	private java.lang.String isDelete; // 
	private java.util.Date createDate; // 
	private java.lang.String createUser; // 
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
     * @return saleName
     */
	public java.lang.String getSaleName() {
		return saleName;
	}
	
	/**
	 * 设置属性
	 *
	 * @param saleName
	 */
	public void setSaleName(java.lang.String saleName) {
		this.saleName = saleName;
	}
	
	/**
     * 获取属性
     *
     * @return city
     */
	public java.lang.String getCity() {
		return city;
	}
	
	/**
	 * 设置属性
	 *
	 * @param city
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	
	/**
     * 获取属性
     *
     * @return address
     */
	public java.lang.String getAddress() {
		return address;
	}
	
	/**
	 * 设置属性
	 *
	 * @param address
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	/**
     * 获取属性
     *
     * @return email
     */
	public java.lang.String getEmail() {
		return email;
	}
	
	/**
	 * 设置属性
	 *
	 * @param email
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	/**
     * 获取属性
     *
     * @return webAddress
     */
	public java.lang.String getWebAddress() {
		return webAddress;
	}
	
	/**
	 * 设置属性
	 *
	 * @param webAddress
	 */
	public void setWebAddress(java.lang.String webAddress) {
		this.webAddress = webAddress;
	}
	
	/**
     * 获取属性
     *
     * @return lat
     */
	public java.lang.String getLat() {
		return lat;
	}
	
	/**
	 * 设置属性
	 *
	 * @param lat
	 */
	public void setLat(java.lang.String lat) {
		this.lat = lat;
	}
	
	/**
     * 获取属性
     *
     * @return lng
     */
	public java.lang.String getLng() {
		return lng;
	}
	
	/**
	 * 设置属性
	 *
	 * @param lng
	 */
	public void setLng(java.lang.String lng) {
		this.lng = lng;
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
	

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebsiteHomepageSalesT");
        sb.append("{id=").append(id);
        sb.append(", saleName=").append(saleName);
        sb.append(", city=").append(city);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", webAddress=").append(webAddress);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
		sb.append('}');
        return sb.toString();
    }
    
}