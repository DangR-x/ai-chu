package com.aichu.service.api;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.*;

import java.util.List;

/**
 * @ClassName AcSystemConfigService
 * @Description 系统配置信息Service
 * @Author Melon
 * @Date 2019/7/20 14:40
 * @Version 1.0.0
 **/
public interface AcSystemConfigService {

    /**
     * @Description 后台系统配置信息列表查询
     * @Param AcSysSystemConfigQueryDTO
     * @Return BaseResponse<List < AcSysSystemConfigDTO>>
     * @Author yuan.shuai
     * @Date 2019/9/19
     * @Version 1.0.0
     */
    BaseResponse<List<AcSysSystemConfigDTO>> getSystemConfigBackList(AcSysSystemConfigQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台系统配置删除
     * @Param id
     * @Return Boolean
     * @Author yuan.shuai
     * @Date 2019/9/19
     * @Version 1.0.0
     */
    Boolean deleteSystemConfig(Integer id) throws Exception;

    /**
     * @Description 后台系统配置新增/修改
     * @Param AcSysSystemConfigDTO
     * @Return Boolean
     * @Author yuan.shuai
     * @Date 2019/9/19
     * @Version 1.0.0
     */
    Boolean addOrUpdateSystemConfig(AcSysSystemConfigDTO configDTO) throws Exception;

    /**
     * @Description 后台优惠卡列表
     * @Author yuan.shuai
     * @Date 2020/2/17 19:52
     * @Param AcQueryOnlyNameDTO
     * @Return BaseResponse<List<AcPreferentialCardBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcPreferentialCardBackDTO>> getPreferentialCardBackList(AcQueryOnlyNameDTO queryDTO) throws Exception;

    /**
     * @Description 后台用户代理主播提成比例设置列表
     * @Author yuan.shuai
     * @Date 2020/2/17 19:52
     * @Param AcSysAgentConfigQueryDTO
     * @Return BaseResponse<List<AcSysAgentConfigBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcSysAgentConfigBackDTO>> getSysAgentConfigBackList(AcSysAgentConfigQueryDTO queryDTO) throws Exception;

    /**
     * @Description 获取代理主播等级下拉列表
     * @Author yuan.shuai
     * @Date 2020/2/18 11:43
     * @Return List<AcUtilIdAndNameDTO>
     * @Version 1.0.0
     **/
    List<AcUtilIdAndNameDTO> getSysAgentConfigSelectList() throws Exception;

    /**
     * @Description 后台优惠卡新增修改
     * @Author yuan.shuai
     * @Date 2020/2/17 19:52
     * @Param AcPreferentialCardBackDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean addOrUpdatePreferentialCardBack(AcPreferentialCardBackDTO backDTO) throws Exception;

    /**
     * @Description 后台优惠卡删除
     * @Author yuan.shuai
     * @Date 2020/2/17 19:52
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean deletePreferentialCardBack(Integer id) throws Exception;

    /**
     * @Description 后台新增修改用户代理主播提成比例设置
     * @Author yuan.shuai
     * @Date 2020/2/17 19:52
     * @Param AcSysAgentConfigBackDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean addOrUpdateSysAgentConfigBack(AcSysAgentConfigBackDTO backDTO) throws Exception;

    /**
     * @Description 后台用户代理主播提成比例设置删除
     * @Author yuan.shuai
     * @Date 2020/2/17 19:52
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean deleteSysAgentConfigBack(Integer id) throws Exception;

    /**
     * @Description 后台充值配置列表查询
     * @Author yuan.shuai
     * @Date 2020/2/19 21:27
     * @Param BasePageOrder
     * @Return BaseResponse<List<AcSysChargeConfigDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcSysChargeConfigDTO>> getSysChargeBackList(BasePageOrder pageOrder) throws Exception;

    /**
     * @Description 后台充值比例修改新增
     * @Author yuan.shuai
     * @Date 2020/2/19 21:27
     * @Param AcSysChargeConfigDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean addOrUpdateSysChargeBack(AcSysChargeConfigDTO configDTO) throws Exception;

    /**
     * @Description 后台充值比例删除
     * @Author yuan.shuai
     * @Date 2020/2/19 21:28
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean deleteSysChargeBack(Integer id) throws Exception;

    /**
     * @Description 后台系统消息列表
     * @Author yuan.shuai
     * @Date 2020/2/22 20:24
     * @Param AcQueryOnlyNameDTO
     * @Return BaseResponse<List<AcSysMessageBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcSysMessageBackDTO>> getSysMessageBackList(AcQueryOnlyNameDTO queryDTO) throws Exception;

    /**
     * @Description 后台系统消息新增修改
     * @Author yuan.shuai
     * @Date 2020/2/22 20:25
     * @Param AcSysMessageBackDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean addOrUpdateSysMessageBack(AcSysMessageBackDTO backDTO) throws Exception;

    /**
     * @Description 后台系统消息删除
     * @Author yuan.shuai
     * @Date 2020/2/22 20:26
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean deleteSysMessageBack(Integer id) throws Exception;

    /**
     * @Description 后台系统消息推送
     * @Author yuan.shuai
     * @Date 2020/2/22 20:26
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean pushSysMessageBack(Integer id) throws Exception;

    /**
     * @Description App版本管理列表
     * @Author Yuan.shuai
     * @Date 2020/3/4 15:51
     * @Param [queryDTO]
     * @return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.AcSysAppVersionBackDTO>>
     **/
    BaseResponse<List<AcSysAppVersionBackDTO>> getAppVersionBackList(AcSysAppVersionBackQueryDTO queryDTO) throws Exception;

    /**
     * @Description APP版本管理新增修改
     * @Author Yuan.shuai
     * @Date 2020/3/4 15:55
     * @Param [addDTO]
     * @return java.lang.Boolean
     **/
    Boolean addOrUpdateAppVersionBack(AcSysAppVersionBackDTO addDTO) throws Exception;

    /**
     * @Description APP版本管理删除
     * @Author Yuan.shuai
     * @Date 2020/3/4 15:55
     * @Param [id]
     * @return java.lang.Boolean
     **/
    Boolean deleteAppVersionBack(Integer id) throws Exception;
}
