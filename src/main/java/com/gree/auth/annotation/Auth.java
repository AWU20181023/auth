package com.gree.auth.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 260152(AWU) on 2018/10/27.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
public @interface Auth {

    boolean needLogin() default true;  //该类或者方法是否需要登陆，默认需要登陆

    String[] permissions() default "";  //拥有的权限
}
