package com.aichu.service.api;

/**
 * @ClassName AcSysFeedbackService
 * @Description 爱触意见反馈信息Service
 * @Author Melon
 * @Date 2019/9/18 19:08
 * @Version 1.0.0
 **/
public interface AcSysFeedbackService {

    /***
     * @Author Melon
     * @Description 用户意见反馈
     * @Date 20:43 2019/10/8
     * @Param [feedBackType, feedBackContent, feedBackContentImg, userId]
     * @Return java.lang.Boolean
     **/
    Boolean userFeedback(Integer feedBackType, String feedBackContent, String feedBackContentImg, Integer userId) throws Exception;
}
