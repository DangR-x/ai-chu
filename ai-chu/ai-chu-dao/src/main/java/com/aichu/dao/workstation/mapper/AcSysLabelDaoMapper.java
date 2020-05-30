package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcLabelQueryDao;
import com.aichu.dao.workstation.object.AcSysLabelDao;
import com.aichu.dao.workstation.object.AcSysLabelSelectDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcSysLabelDaoMapper
 * @Description 系统标签信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcSysLabelDaoMapper {
        
    /***
     * @Author Melon
     * @Description 用户评论标签信息资料
     * @Date 16:56 2019/12/27
     * @Param [impressionLabelId]
     * @Return java.util.List<java.lang.String>
     **/
    List<String> userImpressionLabel(@Param("impressionLabelId") String impressionLabelId);

    /**
     * @Description 根据标签ID查询标签名称
     * @Param labelId (标签Id之间以 ， 分割)
     * @Return java.util.List<String>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    List<String> getSysLabelNameList(String labelId);

    /**
     * @Description 后台活动标签库（下拉框）
     * @Return  java.util.List<YjzhSysLabelSelectDao>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    List<AcSysLabelSelectDao> getLabelSelectList();

    /**
     * @Description 后台系统标签库信息列表查询
     * @Param YjzhLabelQueryDao
     * @Return java.util.List<YjzhSysLabelDao>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    List<AcSysLabelDao> getLabelBackList(AcLabelQueryDao queryDao);

    /**
     * @Description 通过标签类型查询标签名称集合
     * @Author yuan.shuai
     * @Date 2019/12/5 18:48
     * @Param type
     * @Return java.util.List<YjzhSysLabelDao>
     * @Version 1.1.0
     **/
    List<AcSysLabelDao> getLabelNameListToType(@Param("type") Integer type);
}