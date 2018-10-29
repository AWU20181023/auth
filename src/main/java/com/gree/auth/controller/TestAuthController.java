package com.gree.auth.controller;

import com.gree.auth.annotation.Auth;
import com.gree.auth.entity.dto.Result;
import com.gree.auth.utils.ConfigUtils;
import com.gree.auth.utils.SubjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        SubjectUtils.login(response, "260152", "awu");
        return Result.success("恭喜你，登陆成功", null);
    }

    @Auth(needLogin = false)
    @GetMapping("logout")
    public Result logout(HttpServletResponse response, HttpServletRequest request) {
        SubjectUtils.logout(response, request, "260152", "AWU");
        return Result.success("登出系统成功", null);
    }

    @Auth(needLogin = false)
    @GetMapping("noRegister")
    public Result noRegister() {
        return Result.fail("您还未注册", null);
    }

    @Auth(needLogin = false)
    @GetMapping("noPerms")
    public Result noPerms() {
        return Result.fail("您没有操作权限", null);
    }

    @Auth(needLogin = false)
    @GetMapping("timeout")
    public Result timeout() {
        return Result.fail("您长时间未操作，已为您做下线处理", null);
    }
}
