package com.aichu.service.api;

import com.aichu.service.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AcSysProvinceService
 * @Description 省市区地理信息Service
 * @Author Melon
 * @Date 2019/7/23 11:41
 * @Version 1.0.0
 **/
public interface AcSysProvinceService {

    /***
     * @Author Melon
     * @Description 省市区地理信息列表
     * @Date 11:54 2019/7/23
     * @Param []
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     **/
    List<Map<String, Object>> geographyInfoMap() throws Exception;
}
