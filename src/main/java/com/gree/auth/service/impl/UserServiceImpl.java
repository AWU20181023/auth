package com.gree.auth.service.impl;

import com.gree.auth.constant.ConstantEum;
import com.gree.auth.entity.po.User;
import com.gree.auth.service.UserService;
import com.gree.auth.utils.SubjectUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by 260152(AWU) on 2018/10/29 8:31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String isOK(String[] perms, String token) {
        if (perms != null && perms.length > 0) {
            String username = SubjectUtils.getUsername(token);
            String email = SubjectUtils.getEmail(token);
            if (isRegister(email, username)) {
//                if (hasPerms(perms)) {
//                    return ConstantEum.IS_THROUGH.getString();
//                } else return ConstantEum.NO_PERMS.getString();
            } else return ConstantEum.NO_REGISTER.getString();
        }
        return ConstantEum.NO_REGISTER.getString();
    }

    @Override
    public User getByEmailAndUsername(String email, String username) {
        return new User();
    }


    private Boolean isRegister(String email, String username) {
        if (Objects.nonNull(email) || Objects.nonNull(username)) {
            if (!"".equals(email.trim()) || !"".equals(username.trim())) {
                return getByEmailAndUsername(email, username) != null;
            }
        }
        return false;
    }
}
