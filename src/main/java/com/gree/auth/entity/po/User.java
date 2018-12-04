package com.gree.auth.entity.po;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 11:24.
 */
public class User {
    private Integer userId;
    private String email;
    private String salt;
    private String username;
    private String department;
    private Date createdDate;
    private Date updatedDate;
    private List<Role> roleList = new LinkedList<>();

    public User() {
    }

    public User(Integer userId, String email, String salt, String username, String department, Date createdDate, Date updatedDate, List<Role> roleList) {
        this.userId = userId;
        this.email = email;
        this.salt = salt;
        this.username = username;
        this.department = department;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.roleList = roleList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", salt='" + salt + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", roleList=" + roleList +
                '}';
    }
}
