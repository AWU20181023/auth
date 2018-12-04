package com.gree.auth.authentication;

import com.gree.auth.constant.ConstantEum;
import com.gree.auth.dao.PermissionMapper;
import com.gree.auth.dao.RoleMapper;
import com.gree.auth.dao.UserMapper;
import com.gree.auth.entity.po.Permission;
import com.gree.auth.entity.po.Role;
import com.gree.auth.entity.po.User;
import com.gree.auth.utils.SubjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 260152(AWU) on 2018/12/3 14:20.
 */
@Component
public class AuthIdentity {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public String isOK(String[] perms, String token) {
        if (perms != null && perms.length > 0) {
            Set<String> permList = new HashSet<>();
            String username = SubjectUtils.getUsername(token);
            String email = SubjectUtils.getEmail(token);
            User emailAndUsername = userMapper.getPermByEmail(email, username);
            if (emailAndUsername != null) {
                List<Role> roleList = emailAndUsername.getRoleList();
                if (roleList != null && roleList.size() > 0) {
                    roleList.forEach(n -> {
                        List<Permission> permissionList = n.getPermissionList();
                        permissionList.forEach(n2 -> permList.add(n2.getPermission()));
                    });
                }
                if (hasPerms(perms, permList)) {
                    return ConstantEum.IS_THROUGH.getString();
                } else return ConstantEum.NO_PERMS.getString();
            } else return ConstantEum.NO_REGISTER.getString();
        }
        return ConstantEum.NO_REGISTER.getString();
    }


    private boolean hasPerms(String[] perm, Set<String> perms) {
        boolean flag = false;
        if (perm != null && perm.length > 0 && perms != null && perms.size() > 0) {
            for (String per : perm) {
                if (!flag && perms.contains(per)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private Boolean isRegister(String email, String username) {
        if (StringUtils.isNoneBlank(email) && StringUtils.isNoneBlank(username)) {
            return userMapper.getByEmailAndUsername(email, username) != null;
        }
        return false;
    }
}
