package com.gree.auth.entity.po;

import java.util.Date;

/**
 * Created by 260152(AWU) on 2018/10/29 11:24.
 */
public class Permission {
    private Integer permId;
    private Boolean deleted;
    private String name;
    private Long parentId;
    private String permission;
    private String resourceType;
    private String url;
    private Date createdDate;
    private Date updatedDate;

    public Permission() {
    }

    public Permission(Integer permId, Boolean deleted, String name, Long parentId, String permission, String resourceType, String url, Date createdDate, Date updatedDate) {
        this.permId = permId;
        this.deleted = deleted;
        this.name = name;
        this.parentId = parentId;
        this.permission = permission;
        this.resourceType = resourceType;
        this.url = url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        return "Permission{" +
                "permId=" + permId +
                ", deleted=" + deleted +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", permission='" + permission + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
