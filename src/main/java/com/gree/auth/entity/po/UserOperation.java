package com.gree.auth.entity.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by 260152(AWU) on 2018/10/29 18:42.
 */
public class UserOperation {

    private Integer userOperationId;
    private String department;
    private String email;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date operateDate;
    private String operateIp;
    private String operateMethod;
    private String operateParms;
    private String username;

    public UserOperation() {
    }

    public UserOperation(String department, String email, Date operateDate, String operateIp, String operateMethod, String operateParms, String username) {
        this.department = department;
        this.email = email;
        this.operateDate = operateDate;
        this.operateIp = operateIp;
        this.operateMethod = operateMethod;
        this.operateParms = operateParms;
        this.username = username;
    }

    public Integer getUserOperationId() {
        return userOperationId;
    }

    public void setUserOperationId(Integer userOperationId) {
        this.userOperationId = userOperationId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    public String getOperateMethod() {
        return operateMethod;
    }

    public void setOperateMethod(String operateMethod) {
        this.operateMethod = operateMethod;
    }

    public String getOperateParms() {
        return operateParms;
    }

    public void setOperateParms(String operateParms) {
        this.operateParms = operateParms;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
