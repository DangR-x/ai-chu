package com.aichu.dao.workstation.mapper;

import com.aichu.dao.autogeneration.object.AcSysAppVersionDO;
import com.aichu.dao.workstation.object.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcSysConfigDaoMapper
 * @Description 系统配置信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcSysConfigDaoMapper {


    /**
     * @Description 后台系统配置列表信息查询
     * @Param name(关键词), type(配置类型), source(用途)
     * @Return java.util.List<AcSysConfigDao>
     * @Author yuan.shuai
     * @Date 2019/9/19
     * @Version 1.0.0
     */
    List<AcSysConfigDao> getSystemConfigList(@Param("name") String name,
                                             @Param("type") Integer type,
                                             @Param("source") Integer source);

    /**
     * @Description 根据key和配置类型查询配置列表(查分销列表)
     * @Author yuan.shuai
     * @Date 2019/12/13 11:02
     * @Param key，type
     * @Return java.util.List<AcSysConfigDao>
     * @Version 1.0.0
     **/
    List<AcSysConfigDao> getSysSystemComfigList(@Param("keys") String keys,
                                                @Param("type") Integer type);

    /**
     * @Description 后台系统配置修改
     * @Param AcSysConfigDao
     * @Return Integer
     * @Author yuan.shuai
     * @Date 2019/9/19
     * @Version 1.0.0
     */
    Integer updateSystemConfig(AcSysConfigDao configDao);

    /**
     * @Description 后台系统配置新增
     * @Param AcSysConfigDao
     * @Return Integer
     * @Author yuan.shuai
     * @Date 2019/9/19
     * @Version 1.0.0
     */
    Integer insertSystemConfig(AcSysConfigDao configDao);

    /**
     * @Description 后台用户代理主播提成配置列表
     * @Author yuan.shuai
     * @Date 2020/2/17 19:38
     * @Param level
     * @Return List<AcSysAgentConfigBackDao>
     * @Version 1.0.0
     **/
    List<AcSysAgentConfigBackDao> getSysAgentConfigList(@Param("level") Integer level);

    /**
     * @Description 代理主播等级下拉列表
     * @Author yuan.shuai
     * @Date 2020/2/18 11:41
     * @Return List<AcUtilIdAndNameDao>
     * @Version 1.0.0
     **/
    List<AcUtilIdAndNameDao> getSysAgentConfigSelectList();

    /**
     * @Description 系统消息列表查询
     * @Author yuan.shuai
     * @Date 2020/2/22 20:15
     * @Param name
     * @Return List<AcSysMessageDao>
     * @Version 1.0.0
     **/
    List<AcSysMessageDao> getSysMesageBackList(@Param("name") String name);

    /**
     * @Description App版本管理列表
     * @Author Yuan.shuai
     * @Date 2020/3/4 15:29
     * @Param [name, type]
     * @return java.util.List<com.aichu.dao.workstation.object.AcSysAppVersionBackDao>
     **/
    List<AcSysAppVersionBackDao> getAppVersionBackList(@Param("name") String name,
                                                       @Param("type") Integer type);

}