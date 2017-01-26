package com.tywy.sc.data.model;

import java.io.Serializable;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * SystemRole实体表()
 *
 * @author William
 * @date 2016-11-22 11:11:20
 * @project
 */
@SuppressWarnings("serial")
public class SystemRole extends BaseEntity implements Serializable {

    private String id;
    // 角色名称
    private String name;
    // 备注
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
