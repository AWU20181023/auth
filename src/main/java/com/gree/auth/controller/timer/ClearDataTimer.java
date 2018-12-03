package com.gree.auth.controller.timer;

import com.gree.auth.utils.SubjectUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by 260152(AWU) on 2018/12/3 16:22.
 */
@Component
public class ClearDataTimer {

    @Scheduled(fixedDelay = 24 * 60 * 60 * 1000)
    public void clearData() {
        SubjectUtils.clearTimeoutToken();
    }
}
