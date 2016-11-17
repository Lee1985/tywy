package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * user_info实体表()
 * @author lipeng
 * @date 2016-11-17 16:48:35
 * @project 
 */
 @SuppressWarnings("serial")
public class UserInfo extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String name; // 
	private java.lang.String age; // 
	private java.lang.String sex; // 
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
     * @return name
     */
	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * 设置属性
	 *
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	/**
     * 获取属性
     *
     * @return age
     */
	public java.lang.String getAge() {
		return age;
	}
	
	/**
	 * 设置属性
	 *
	 * @param age
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}
	
	/**
     * 获取属性
     *
     * @return sex
     */
	public java.lang.String getSex() {
		return sex;
	}
	
	/**
	 * 设置属性
	 *
	 * @param sex
	 */
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}
	

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UserInfo");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
		sb.append('}');
        return sb.toString();
    }
    
}