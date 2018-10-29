package com.gree.auth.dao;

import com.gree.auth.AuthApplicationTests;
import com.gree.auth.entity.po.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 16:04.
 */
public class RoleMapperTest extends AuthApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testRoleMapper() {
        List<Role> allRole = roleMapper.getAllRole();
        allRole.forEach(System.out::println);
    }
}