package com.aichu.service.api;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.AcSysBannerBackDTO;
import com.aichu.service.dto.AcSysBannerBackQueryDTO;

import java.util.List;

/**
 * @ClassName NlSystemBannerService
 * @Description 系统信息BannerService
 * @Author Melon
 * @Date 2019/7/20 14:40
 * @Version 1.0.0
 **/
public interface AcSystemBannerService {

    /***
     * @Author Melon
     * @Description 系统信息Banner信息列表
     * @Date 14:52 2019/8/24
     * @Param []
     * @Return java.util.List<java.lang.String>
     **/
    List<String> systemBanner() throws Exception;

    /**
     * @Description 后台系统Banner管理列表查询
     * @Param AcSysBannerBackQueryDTO
     * @Return BaseResponse<List < AcSysBannerBackDTO>>
     * @Author yuan.shuai
     * @Date 2019/8/26
     * @Version 1.0.0
     */
    BaseResponse<List<AcSysBannerBackDTO>> getBannerBackList(AcSysBannerBackQueryDTO backQueryDTO) throws Exception;

    /**
     * @Description 后台系统banner新增或者修改
     * @Param AcSysBannerBackDTO
     * @Return Boolean
     * @Author yuan.shuai
     * @Date 2019/8/26
     * @Version 1.0.0
     */
    Boolean addOrUpdateBannerBack(AcSysBannerBackDTO bannerBackDTO) throws Exception;

    /**
     * @Description 后台系统Banner删除
     * @Param id
     * @Return Boolean
     * @Author yuan.shuai
     * @Date 2019/8/26
     * @Version 1.0.0
     */
    Boolean deleteBannerBack(Integer id) throws Exception;
}
