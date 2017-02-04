package com.tywy.sc.data.model;

import java.io.Serializable;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * SystemUserInfo实体表()
 *
 * @author William
 * @date 2016-11-22 11:11:20
 * @project
 */
public class SystemUser extends BaseEntity implements Serializable {

    // 主键
    private String id;
    // 用户账号
    private String userId;
    // 用户名称
    private String userName;
    // 用户密码
    private String userPwd;
    // 角色ID
    private String roleId;
    // 手机号码
    private String mobile;
    // 邮箱
    private String email;
    // 地址
    private String address;
    // 状态
    private Integer status;
    // 备注
    private String description;
    //是否删除
    private String isDelete;

    // 角色对象
    private SystemRole systemRole = new SystemRole();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
