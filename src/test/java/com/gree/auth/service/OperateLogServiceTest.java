package com.gree.auth.service;

import com.gree.auth.AuthApplicationTests;
import com.gree.auth.entity.po.UserOperation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 260152(AWU) on 2018/10/29 19:10.
 */
public class OperateLogServiceTest extends AuthApplicationTests {
    @Autowired
    private OperateLogService operateLogService;

    @Test
    public void testOperateLog() {
        UserOperation userOperation = new UserOperation();
        operateLogService.saveUserOperate(userOperation);
    }

}