package com.aichu.service.api;

import com.aichu.service.dto.AppVersionInfoDTO;
import com.aichu.service.dto.CustomerInfoDTO;

/**
 * @ClassName AcSysSystemConfigService
 * @Description 爱触系统配置信息Service
 * @Author Melon
 * @Date 2019/9/18 19:08
 * @Version 1.0.0
 **/
public interface AcSysSystemConfigService {

    /***
     * @Author Melon
     * @Description 爱触协议信息
     * @Date 17:34 2019/12/31
     * @Param [policyType, userId]
     * @Return java.lang.String
     **/
    String systemPolicy(Integer policyType, Integer userId) throws Exception;
    
    /***
     * @Author Melon
     * @Description 客服联系信息
     * @Date 16:16 2020/2/21
     * @Param []
     * @Return com.aichu.service.dto.CustomerInfoDTO
     **/
    CustomerInfoDTO customerInfo() throws Exception;
    
    /**
     * @Description APP版本查验
     * @Author Melon
     * @Date 2020/3/3 18:39
     * @Param [appType, version] 
     * @return com.aichu.service.dto.AppVersionInfoDTO 
     **/
    AppVersionInfoDTO customerAppVersion(Integer appType, Integer version) throws Exception;
}
