package com.gree.auth.interceptor;

import com.gree.auth.annotation.Auth;
import com.gree.auth.constant.ConstantEum;
import com.gree.auth.service.UserService;
import com.gree.auth.utils.CookieUtils;
import com.gree.auth.utils.SubjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 260152(AWU) on 2018/10/27.
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private void setUserService(UserService userService) {
        AuthInterceptor.userService = userService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        HandlerMethod method = null;
        try {
            method = (HandlerMethod) handler;
        } catch (ClassCastException e) {
            try {
                return loginToLogin(request, response);
            } catch (IOException e1) {
                logger.error("跳转到登陆页出现问题了");
                return false;
            }
        }
        if (method != null) {
            //获取方法上的注解
            Auth methodAnnotationauth = method.getMethodAnnotation(Auth.class);
            //获取类上的注解
            Auth beanAuth = method.getBeanType().getAnnotation(Auth.class);
            //假如两个注解都有值，以方法上的为主
            if (methodAnnotationauth != null) {
                return execAuth(methodAnnotationauth, request, response);
            } else if (beanAuth != null) {
                return execAuth(beanAuth, request, response);
            }
            return true;
        }
        return false;
    }

    private boolean execAuth(Auth auth, HttpServletRequest request, HttpServletResponse response) {
        if (auth != null) {
            if (auth.needLogin()) {  //需要登陆
                //1.判断是否登陆，未登录的进行登陆，已经登陆的进行权限判断
                String token = CookieUtils.getValue(request, ConstantEum.LOGIN_TOKEN.getString());
                String login = SubjectUtils.isLogin(token);
                if (ConstantEum.LOGINING.getString().equals(login)) {  //登陆中
                    //正常登陆状态，鉴权
                    String result = authThePermis(auth.permissions(), token);
                    if (ConstantEum.NO_PERMS.getString().equals(result)) {
                        try {
                            return loginToNoPerms(request, response);
                        } catch (IOException e) {
                            logger.error("跳转到NoPerms页出现问题了");
                            return false;
                        }
                    } else if (ConstantEum.IS_THROUGH.getString().equals(result)) {
                        return true;
                    } else if (ConstantEum.NO_REGISTER.getString().equals(result)) {
                        try {
                            return loginToNoRegister(request, response);
                        } catch (IOException e) {
                            logger.error("跳转到NoRegister页出现问题了");
                            return false;
                        }
                    }
                } else if (ConstantEum.TOKEN_TIMEOUT.getString().equals(login)) {  //token超时
                    try {
                        return loginToTimeout(request, response);
                    } catch (IOException e) {
                        logger.error("跳转到Timeout页出现问题了");
                        return false;
                    }
                } else {  //未登陆，跳到登陆页
                    try {
                        return loginToLogin(request, response);
                    } catch (IOException e) {
                        logger.error("跳转到登陆页出现问题了");
                        return false;
                    }
                }
            } else {  //不需要登陆，直接return true
                return true;
            }
        } else return true;
        return true;
    }

    /**
     * @return true 有权限；false 无权限
     */
    private String authThePermis(String[] permissions, String token) {
        return userService.isOK(permissions, token);
    }

    private boolean loginToNoRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/auth/noRegister");
        return false;
    }

    private boolean loginToNoPerms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/auth/noPerms");
        return false;
    }


    private boolean loginToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/auth/login");
        return false;
    }

    private boolean loginToTimeout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/auth/timeout");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
