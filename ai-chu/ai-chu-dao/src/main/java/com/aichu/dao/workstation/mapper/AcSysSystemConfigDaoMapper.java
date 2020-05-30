package com.aichu.dao.workstation.mapper;

import com.aichu.dao.autogeneration.object.AcSysConfigDO;
import com.aichu.dao.workstation.object.AcSysChargeConfigDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcSysSystemConfigDaoMapper
 * @Description 爱触系统配置信息DaoMapper
 * @Author Melon
 * @Date 2019/9/18 21:04
 * @Version 1.0.0
 **/
public interface AcSysSystemConfigDaoMapper {
    
    /***
     * @Author Melon
     * @Description 爱触协议信息
     * @Date 17:41 2019/12/31
     * @Param [policyType]
     * @Return com.aichu.dao.autogeneration.object.AcSysConfigDO
     **/
    AcSysConfigDO systemPolicy(@Param("policyType") Integer policyType);

    /**
     * @Description 后台充值配置列表
     * @Author yuan.shuai
     * @Date 2020/2/19 21:14
     * @Return List<AcSysChargeConfigDao>
     * @Version 1.0.0
     **/
    List<AcSysChargeConfigDao> getSysChargeConfigList();
}
