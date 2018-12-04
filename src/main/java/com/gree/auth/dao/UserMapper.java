package com.gree.auth.dao;

import com.gree.auth.entity.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 15:51.
 */
public interface UserMapper {
    List<User> getAllUser();

    User getByEmailAndUsername(@Param("email") String email, @Param("username") String username);

    User getPermByEmail(@Param("email") String email);
}
