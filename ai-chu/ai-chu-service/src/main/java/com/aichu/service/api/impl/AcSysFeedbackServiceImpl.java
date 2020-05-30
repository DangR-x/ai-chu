package com.aichu.service.api.impl;

import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcSysFeedbackMapper;
import com.aichu.dao.autogeneration.object.AcSysFeedbackDO;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.service.api.AcSysFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AcSysFeedbackServiceImpl
 * @Description 爱触意见反馈信息ServiceImlpl
 * @Author Melon
 * @Date 2019/9/18 19:09
 * @Version 1.0.0
 **/
@Service
public class AcSysFeedbackServiceImpl implements AcSysFeedbackService {

    private Logger logger = LoggerFactory.getLogger(AcSysFeedbackServiceImpl.class);

    @Autowired
    private AcSysFeedbackMapper acSysFeedbackMapper;

    @Override
    public Boolean userFeedback(Integer feedBackType, String feedBackContent, String feedBackContentImg, Integer userId) throws Exception {
        logger.info("--------------用户意见反馈-----------Start-- feedBackType:--{}, feedBackContent:--{}, feedBackContentImg:--{}, userId:--{}",
                feedBackType, feedBackContent, feedBackContentImg, userId);

        AcSysFeedbackDO acSysFeedbackDO = new AcSysFeedbackDO();
        acSysFeedbackDO.setUserId(userId);
        acSysFeedbackDO.setContent(feedBackContent);
        acSysFeedbackDO.setContentImg(feedBackContentImg);
        acSysFeedbackDO.setFeedbackType(feedBackType);
        Integer result = acSysFeedbackMapper.insertSelective(acSysFeedbackDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.FEED_BACK_ADD_ERROR.code(), ResultCodeEnum.FEED_BACK_ADD_ERROR.message());
        }

        logger.info("--------------用户意见反馈----------End");
        return true;
    }
}
