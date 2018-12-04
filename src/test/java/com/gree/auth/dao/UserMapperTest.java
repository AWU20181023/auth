package com.gree.auth.dao;

import com.gree.auth.AuthApplicationTests;
import com.gree.auth.entity.po.User;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 15:54.
 */
public class UserMapperTest extends AuthApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testGetByCondition() {
        User awu = userMapper.getByEmailAndUsername("260152", "awu");
        System.out.println(awu);
    }

    @Test
    public void testGetPermByEmail() {
        User permByEmail = userMapper.getPermByEmail("260152","awu");
        System.out.println(permByEmail);
    }
}