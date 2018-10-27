package com.gree.auth.constant;

/**
 * Created by 260152(AWU) on 2018/10/27 14:03.
 */
public enum ConstantEum {

    LOGIN_TOKEN("LOGIN_TOKEN"),

    NO_LOGIN("0"),
    TOKEN_TIMEOUT("1"),
    LOGINING("2"),

    DELIMITER("******"),
    ;
    private String string;

    public String getString() {
        return string;
    }

    ConstantEum() {
    }

    ConstantEum(String string) {
        this.string = string;
    }
}
