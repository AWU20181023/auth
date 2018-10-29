package com.gree.auth.dao;

import com.gree.auth.entity.po.Role;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 15:57.
 */
public interface RoleMapper {
    List<Role> getAllRole();

    Role getRoleById(String role);
}
