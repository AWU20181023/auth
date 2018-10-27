package com.gree.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class TestAuthController {

    @GetMapping("testAuth")
    public String testAuth() {
        return "恭喜你，看到了我";
    }
}
