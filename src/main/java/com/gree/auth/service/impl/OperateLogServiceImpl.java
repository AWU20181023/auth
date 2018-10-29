package com.gree.auth.service.impl;

import com.gree.auth.dao.UserOperationMapper;
import com.gree.auth.entity.po.UserOperation;
import com.gree.auth.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 260152(AWU) on 2018/10/29 18:40.
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private UserOperationMapper userOperationMapper;

    @Override
    public void saveUserOperate(UserOperation userOperation) {
        userOperationMapper.insert(userOperation);
    }
}
