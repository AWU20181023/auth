package com.gree.auth.entity.dto;

import com.gree.auth.constant.ConstantEum;

/**
 * Created by 260152(AWU) on 2018/10/29 11:18.
 */
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(ConstantEum.OPREATE_SUCCESS.getInteger(), "success", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(ConstantEum.OPREATE_SUCCESS.getInteger(), msg, data);
    }

    public static Result fail(String msg, Object data) {
        return new Result(ConstantEum.OPERATE_FAIL.getInteger(), msg, data);
    }

    public static Result fail(ConstantEum constantEum, String msg, Object data) {
        return new Result(constantEum.getInteger(), msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
