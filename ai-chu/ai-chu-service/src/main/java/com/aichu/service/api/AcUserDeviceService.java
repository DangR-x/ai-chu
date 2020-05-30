package com.aichu.service.api;

/**
 * @ClassName AcUserDeviceService
 * @Description 即时通讯设备信息Service
 * @Author Melon
 * @Date 2019/7/20 14:40
 * @Version 1.0.0
 **/
public interface AcUserDeviceService {

    /***
     * @Author Melon
     * @Description 消息推送绑定设备信息
     * @Date 18:25 2020/1/13
     * @Param [deviceNo, deviceType, userId]
     * @Return java.lang.Boolean
     **/
    Boolean deviceBindDeviceNo(String deviceNo, Integer deviceType, Integer userId) throws Exception;
}
