package com.gree.auth.service;

import com.gree.auth.entity.po.UserOperation;

/**
 * Created by 260152(AWU) on 2018/10/29 18:40.
 */
public interface OperateLogService {
    void saveUserOperate(UserOperation userOperation);
}
