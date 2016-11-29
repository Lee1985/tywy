package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * system_menu_info实体表()
 * @author lipeng
 * @date 2016-11-22 22:14:16
 * @project 
 */
 @SuppressWarnings("serial")
public class SystemMenuInfo extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.String name; // 菜单名称
	private java.lang.String pid; // 父级ID
	private java.lang.String menuUrl; // 跳转路径
	private java.lang.Integer level; // 级别
	private java.lang.Integer orderList; // 排序
	private java.lang.String description; // 备注
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
     * 获取菜单名称属性
     *
     * @return name
     */
	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * 设置菜单名称属性
	 *
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	/**
     * 获取父级ID属性
     *
     * @return pid
     */
	public java.lang.String getPid() {
		return pid;
	}
	
	/**
	 * 设置父级ID属性
	 *
	 * @param pid
	 */
	public void setPid(java.lang.String pid) {
		this.pid = pid;
	}
	
	/**
     * 获取跳转路径属性
     *
     * @return menuUrl
     */
	public java.lang.String getMenuUrl() {
		return menuUrl;
	}
	
	/**
	 * 设置跳转路径属性
	 *
	 * @param menuUrl
	 */
	public void setMenuUrl(java.lang.String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	/**
     * 获取级别属性
     *
     * @return level
     */
	public java.lang.Integer getLevel() {
		return level;
	}
	
	/**
	 * 设置级别属性
	 *
	 * @param level
	 */
	public void setLevel(java.lang.Integer level) {
		this.level = level;
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
     * 获取备注属性
     *
     * @return description
     */
	public java.lang.String getDescription() {
		return description;
	}
	
	/**
	 * 设置备注属性
	 *
	 * @param description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SystemMenuInfo");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", level=").append(level);
        sb.append(", orderList=").append(orderList);
        sb.append(", description=").append(description);
		sb.append('}');
        return sb.toString();
    }
    
}