package com.gree.auth.controller;

import com.gree.auth.annotation.Auth;
import com.gree.auth.utils.SubjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 260152(AWU) on 2018/10/27.
 */
@Auth(permissions = {"cc", "dd"})
@RestController
@RequestMapping("auth")
public class TestAuthController {

    @Auth(permissions = {"aa", "bb"})
    @GetMapping("testAuth")
    public String testAuth() {
        return "恭喜你，看到了我";
    }

    @Auth(permissions = {"ee", "ff"}, needLogin = false)
    @GetMapping("testAuth2")
    public String testAuth2() {
        return "恭喜你，看到了我2";
    }

    @Auth(needLogin = false)
    @GetMapping("login")
    public String login(HttpServletResponse response) {
        SubjectUtils.login(response, "260152", "AWU");
        return "恭喜你，登陆了";
    }

    @Auth(needLogin = false)
    @GetMapping("logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        SubjectUtils.logout(response, request, "260152", "AWU");
        return "恭喜你，退出了";
    }
}
