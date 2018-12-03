package com.gree.auth.service.impl;

import com.gree.auth.constant.ConstantEum;
import com.gree.auth.dao.PermissionMapper;
import com.gree.auth.dao.RoleMapper;
import com.gree.auth.dao.UserMapper;
import com.gree.auth.entity.po.Permission;
import com.gree.auth.entity.po.Role;
import com.gree.auth.entity.po.User;
import com.gree.auth.service.UserService;
import com.gree.auth.utils.SubjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 260152(AWU) on 2018/10/29 8:31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByEmailAndUsername(String email, String username) {
        if (StringUtils.isNoneBlank(email) && StringUtils.isNoneBlank(username)) {
            return userMapper.getByEmailAndUsername(email, username);
        }
        return null;
    }
}
