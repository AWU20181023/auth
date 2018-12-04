package com.gree.auth.entity.po;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 11:24.
 */
public class Role {
    private Integer roleId;
    private Boolean deleted;
    private String description;
    private String rolename;
    private Integer parentId;
    private Date createdDate;
    private Date updatedDate;
    private List<Permission> permissionList = new LinkedList<>();

    public Role() {
    }

    public Role(Integer roleId, Boolean deleted, String description, String rolename, Integer parentId, Date createdDate, Date updatedDate, List<Permission> permissionList) {
        this.roleId = roleId;
        this.deleted = deleted;
        this.description = description;
        this.rolename = rolename;
        this.parentId = parentId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.permissionList = permissionList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", deleted=" + deleted +
                ", description='" + description + '\'' +
                ", rolename='" + rolename + '\'' +
                ", parentId=" + parentId +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", permissionList=" + permissionList +
                '}';
    }
}
