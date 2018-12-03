package com.gree.auth.constant;

/**
 * Created by 260152(AWU) on 2018/10/27 14:03.
 */
public enum ConstantEum {

    LOGIN_TOKEN("LOGIN_TOKEN"),
    AUTH_METHOD("AUTH_METHOD"),

    NO_LOGIN("0"),
    TOKEN_TIMEOUT("1"),
    LOGINING("2"),

    USE_COOKIE(0),
    USE_TOKEN(1),

    NO_PERMS("0"),
    IS_THROUGH("1"),
    NO_REGISTER("2"),

    // 登陆相关：500000-500099之间
    AUTH_NO_LOGIN(500001),
    AUTH_NO_REGISTER(500002),
    AUTH_NO_PERMS(500003),
    AUTH_TIME_OUT(500004),
    // 成功相关：500200-500299之间
    OPREATE_SUCCESS(500200),
    // 失败相关：500500-500599之间
    OPERATE_FAIL(500500),

    DELIMITER("---"),
    ;
    private String string;
    private Integer integer;

    public String getString() {
        return string;
    }

    public Integer getInteger() {
        return integer;
    }

    ConstantEum() {
    }

    ConstantEum(String string) {
        this.string = string;
    }

    ConstantEum(Integer integer) {
        this.integer = integer;
    }
}
