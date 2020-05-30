package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcSysBannerBackDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcSysBannerDaoMapper
 * @Author yuan.shuai
 * @Description 系统Banner管理Mapper
 * @Date 2019/8/26
 * @Version 1.0.0
 */
public interface AcSysBannerDaoMapper {

    /**
     * @Description 后台系统Banner管理列表查询
     * @Param name(关键词)，type(banner类型)
     * @Return java.util.List<YjzhSysBannerBackDao>
     * @Author yuan.shuai
     * @Date  2019/8/26
     * @Version 1.0.0
     */
    List<AcSysBannerBackDao> getBannerBackList(@Param("name") String name, @Param("type") Integer type);
}
