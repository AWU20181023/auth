package com.gree.auth.dao;

import com.gree.auth.entity.po.Permission;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 15:57.
 */
public interface PermissionMapper {
    List<Permission> getAllPermissions();
}
