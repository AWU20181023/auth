package com.gree.auth.dao;

import com.gree.auth.AuthApplicationTests;
import com.gree.auth.entity.po.Permission;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 16:05.
 */
public class PermissionMapperTest extends AuthApplicationTests {
    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void testPermissionMapper() {
        List<Permission> allPermissions = permissionMapper.getAllPermissions();
        for (Permission allPermission : allPermissions) {
            System.out.println(allPermission);
        }
    }
}