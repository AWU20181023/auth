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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by 260152(AWU) on 2018/10/29 8:31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    private Map<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User getByEmailAndUsername(String email, String username) {
        if (StringUtils.isNoneBlank(email) && StringUtils.isNoneBlank(username)) {
            return userMapper.getByEmailAndUsername(email, username);
        }
        return null;
    }

    @Override
    public User getPermsByEmail(String email, String username) {
        if (email != null) {
            User user = userMap.get(email);
            if (user != null) {
                return user;
            } else {
                User permByEmail = userMapper.getPermByEmail(email, username);
                userMap.put(email, permByEmail);
                return permByEmail;
            }
        } else {
            return null;
        }
    }

    // TODO: 2018/12/4 更新操作记得清除
    @Override
    public void clearDataByEmail(String email) {
        User user = userMap.get(email);
        if (user != null) {
            userMap.remove(email);
        }
    }

}
