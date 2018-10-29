package com.gree.auth.entity.po;

/**
 * Created by 260152(AWU) on 2018/10/29 11:24.
 */
public class User {
    private Integer userInfoId;
    private String email;
    private String salt;
    private String username;
    private String department;
    private String roles;

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userInfoId=" + userInfoId +
                ", email='" + email + '\'' +
                ", salt='" + salt + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
