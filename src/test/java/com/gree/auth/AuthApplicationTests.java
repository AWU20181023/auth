package com.gree.auth;

import com.gree.auth.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthApplicationTests {

    @Test
    public void contextLoads() {

        List<UserService> monitorLists = new ArrayList<>();
        Reflections reflections = new Reflections("com.gree.auth.service.impl");
        Set<Class<? extends UserService>> monitorClasses = reflections.getSubTypesOf(UserService.class);
        for (Class<? extends UserService> monitor : monitorClasses) {
            try {
                UserService userService = monitor.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
