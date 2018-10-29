package com.gree.auth.aspect;

import com.gree.auth.constant.ConstantEum;
import com.gree.auth.entity.po.UserOperation;
import com.gree.auth.service.OperateLogService;
import com.gree.auth.utils.ConfigUtils;
import com.gree.auth.utils.CookieUtils;
import com.gree.auth.utils.SubjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 260152(AWU) on 2018/10/29 18:30.
 */
@Component
@Aspect
public class OperateAspect {

    @Autowired
    private OperateLogService operateLogService;

    @Around("execution(* com.gree.auth.controller..*(..))")
    public Object rememberSomeoneDoSomething(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object proceed = proceedingJoinPoint.proceed();

        Object[] args = proceedingJoinPoint.getArgs();
        StringBuilder stringBuffer = new StringBuilder();
        for (Object arg : args) {
            stringBuffer.append(arg).append(";");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        String execution = proceedingJoinPoint.toString();
        String params = stringBuffer.toString();

        String username = "未知姓名";
        String email = "未知邮箱";
        String departmentName = "未知部门";

        HttpServletRequest httpServletRequest = null;

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {//正常请求
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            httpServletRequest = servletRequestAttributes.getRequest();
        }

        String remoteAddr = ConfigUtils.getLocalhost();
        String username1 = null;
        String email1 = null;

        if (httpServletRequest != null) {
            remoteAddr = httpServletRequest.getRemoteAddr();
            String token = CookieUtils.getValue(httpServletRequest, ConstantEum.LOGIN_TOKEN.getString());
            username1 = SubjectUtils.getUsername(token);
            email1 = SubjectUtils.getEmail(token);
        }

        if (httpServletRequest != null) {
            if (username1 != null && email1 != null) {
                username = username1;
                email = email1;
            } else {
                HttpSession session = null;
                try {
                    session = httpServletRequest.getSession();
                } catch (Exception e) {
                    System.out.println("rememberSomeoneDoSomething() no session");
                }
                if (session != null) {
                    String userName = (String) session.getAttribute("userName");
                    if (userName != null) {
                        username = userName;
                    }
                    String email2 = (String) session.getAttribute("email");
                    if (email2 != null) {
                        email = email2;
                    }
                    String departmentName1 = (String) session.getAttribute("departmentName");
                    if (departmentName1 != null) {
                        departmentName = departmentName1;
                    }
                }
            }
        } else {
            username = "系统内部调用";
            email = "系统内部调用";
        }

        if (params.length() > 512) {//防止过长参数造成的异常
            params = params.substring(0, 510);
        }

        UserOperation userOperation = new UserOperation(departmentName, email, new Date(), remoteAddr, execution, params, username);
        operateLogService.saveUserOperate(userOperation);
        return proceed;
    }
}
