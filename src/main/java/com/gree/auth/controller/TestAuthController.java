package com.gree.auth.controller;

import com.gree.auth.annotation.Auth;
import com.gree.auth.constant.ConstantEum;
import com.gree.auth.entity.dto.Result;
import com.gree.auth.utils.AuthMethodUtils;
import com.gree.auth.utils.ConfigUtils;
import com.gree.auth.utils.SubjectUtils;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 260152(AWU) on 2018/10/27.
 */
@RestController
@RequestMapping("auth")
public class TestAuthController {

    @Auth(permissions = {"user:delete"})
    @GetMapping("testAuth")
    public Result testAuth() {
        return Result.success("恭喜你，看到了我", null);
    }

    @Auth(needLogin = false)
    @GetMapping("testAuth2")
    public Result testAuth2() {
        return Result.success("恭喜你，看到了我2", null);
    }

    @Auth(needLogin = false)
    @GetMapping("login")
    public Result login(HttpServletResponse response) {
        String auth = SubjectUtils.login(response, "260152", "awu");
        Map<String, String> map = null;
        if (auth != null) {
            map = new HashMap<>();
            map.put("Authorization", auth);
        }
        return Result.success("恭喜你，登陆成功", map);
    }

    @Auth(needLogin = false)
    @GetMapping("logout")
    public Result logout(HttpServletResponse response, HttpServletRequest request) {
        SubjectUtils.logout(response, request, "260152", "AWU");
        return Result.success("登出系统成功", null);
    }
}
