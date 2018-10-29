package com.gree.auth.service;

import com.gree.auth.entity.po.User;

/**
 * Created by 260152(AWU) on 2018/10/29 8:31.
 */
public interface UserService {
    String isOK(String[] perms, String token);

    User getByEmailAndUsername(String email, String username);
}
