package com.gree.auth.dao;

import com.gree.auth.entity.po.User;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 15:51.
 */
public interface UserMapper {
    List<User> getAllUser();
}
