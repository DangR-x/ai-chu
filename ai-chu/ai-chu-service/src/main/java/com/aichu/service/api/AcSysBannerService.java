package com.aichu.service.api;

import java.util.List;

/**
 * @ClassName AcSysBannerService
 * @Description 系统Banner信息Service
 * @Author Melon
 * @Date 2019/7/23 11:41
 * @Version 1.0.0
 **/
public interface AcSysBannerService {

    /***
     * @Author Melon
     * @Description 系统Banner字典信息
     * @Date 18:16 2019/12/26
     * @Param [bannerType]
     * @Return java.util.List<java.lang.String>
     **/
    List<String> systemBannerDictInfoList(Integer bannerType) throws Exception;
}
