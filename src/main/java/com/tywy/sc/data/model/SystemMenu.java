package com.tywy.sc.data.model;

import com.tywy.sc.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * SystemMenu实体表()
 *
 * @author William
 * @date 2016-11-22 11:11:20
 * @project
 */
public class SystemMenu extends BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    // 菜单名称
    private String name;
    // 父级
    private String pid;
    // 跳转URL
    private String menuUrl;
    // 排序
    private Integer orderList;
    // 备注
    private String description;

    private Integer level;

    private List<SystemMenu> children;

    private List<SystemMenuAct> systemMenuActs;

    private List<String> ids;

    private String moveType;

    private Integer isCheck;

    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getOrderList() {
        return orderList;
    }

    public void setOrderList(Integer orderList) {
        this.orderList = orderList;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<SystemMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SystemMenu> children) {
        this.children = children;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public List<SystemMenuAct> getSystemMenuActs() {
        return systemMenuActs;
    }

    public void setSystemMenuActs(List<SystemMenuAct> systemMenuActs) {
        this.systemMenuActs = systemMenuActs;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
