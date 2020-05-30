package com.aichu.service.api;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.*;
import com.aichu.service.dto.ChargeConfigDTO;
import com.aichu.service.dto.PreferentialCardDTO;
import com.aichu.service.dto.UserChartGoodsListDTO;

import java.util.List;

/**
 * @ClassName AcChartGoodsService
 * @Description 爱触商品信息Service
 * @Author Melon
 * @Date 2019/9/18 19:08
 * @Version 1.0.0
 **/
public interface AcChartGoodsService {

    /***
     * @Author Melon
     * @Description 聊天商品信息
     * @Date 10:26 2020/1/10
     * @Param []
     * @Return java.util.List<com.aichu.service.dto.UserChartGoodsListDTO>
     **/
    List<UserChartGoodsListDTO> cloudChartGoodsList() throws Exception;

    /***
     * @Author Melon
     * @Description 优惠卡信息
     * @Date 14:29 2020/2/19
     * @Param []
     * @Return java.util.List<com.aichu.service.dto.PreferentialCardDTO>
     **/
    List<PreferentialCardDTO> preferentialCard() throws Exception;

    /***
     * @Author Melon
     * @Description 充值配置信息
     * @Date 14:43 2020/2/19
     * @Param []
     * @Return java.util.List<com.aichu.service.dto.ChargeConfigDTO>
     **/
    List<ChargeConfigDTO> chargeConfig() throws Exception;

    /**
     * @Description 后台商品信息列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 10:17
     * @Param AcChartGoodsQuqeryDTO
     * @Return BaseResponse<List<AcChartGoodsDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcChartGoodsDTO>> getChartGoodsListBack(AcChartGoodsQuqeryDTO queryDTO) throws Exception;

    /**
     * @Description 后台新增修改商品信息
     * @Author yuan.shuai
     * @Date 2020/2/17 10:17
     * @Param AcChartGoodsDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean addOrUpdateChartGoodsBack(AcChartGoodsDTO updateDto) throws Exception;

    /**
     * @Description 后台商品信息删除
     * @Author yuan.shuai
     * @Date 2020/2/17 10:17
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean deleteChartGoodsBack(Integer id) throws Exception;

    /**
     * @Description 后台商品购买记录列表
     * @Author yuan.shuai
     * @Date 2020/2/17 11:41
     * @Param AcQueryOnlyNameDTO
     * @Return  BaseResponse<List<AcChartGoodsRecordsDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcChartGoodsRecordsDTO>> getChartGoodsRecordList(AcQueryOnlyNameDTO queryDTO) throws Exception;

    /**
     * @Description 商品上架下架
     * @Author yuan.shuai
     * @Date 2020/2/18 14:48
     * @Param AcUtilIdAndStatusDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean putawayGoodsBack(AcUtilIdAndStatusDTO updateDTO) throws Exception;
}
