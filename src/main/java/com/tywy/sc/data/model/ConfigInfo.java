package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * config_info实体表()
 * @author lipeng
 * @date 2017-02-15 17:59:04
 * @project 
 */
 @SuppressWarnings("serial")
public class ConfigInfo extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String configKey; // 
	private java.lang.String configValue; // 
	private java.lang.String createUser; // 
	private java.util.Date createDate; // 
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
     * 获取属性
     *
     * @return configKey
     */
	public java.lang.String getConfigKey() {
		return configKey;
	}
	
	/**
	 * 设置属性
	 *
	 * @param configKey
	 */
	public void setConfigKey(java.lang.String configKey) {
		this.configKey = configKey;
	}
	
	/**
     * 获取属性
     *
     * @return configValue
     */
	public java.lang.String getConfigValue() {
		return configValue;
	}
	
	/**
	 * 设置属性
	 *
	 * @param configValue
	 */
	public void setConfigValue(java.lang.String configValue) {
		this.configValue = configValue;
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
        sb.append("ConfigInfo");
        sb.append("{id=").append(id);
        sb.append(", configKey=").append(configKey);
        sb.append(", configValue=").append(configValue);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
		sb.append('}');
        return sb.toString();
    }
    
}