package com.aichu.app.task;

import com.aichu.service.api.AcUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserSignCardTask
 * @Description 用户优惠卡签到信息定时任务
 * @Author Melon
 * @Date 2019/9/27 15:46
 * @Version 1.0.0
 **/
@Component
public class UserSignCardTask {

    private Logger logger = LoggerFactory.getLogger(UserSignCardTask.class);

    @Autowired
    private AcUserService acUserService;

    //每天十二点执行一次状态处理
    //@Scheduled(cron = "0 0 24 * * ?")
    public void userSignCardTaskHandle(){
        try {
            acUserService.userSignCardTaskHandle();
        } catch (Exception e) {
            logger.error("红包订单记录倒计时处理任务失败!",e);
        }
    }
}
