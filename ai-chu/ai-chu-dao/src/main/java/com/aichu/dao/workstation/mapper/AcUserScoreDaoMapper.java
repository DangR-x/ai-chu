package com.aichu.dao.workstation.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcUserScoreDaoMapper
 * @Description 系统用户评论标签信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcUserScoreDaoMapper {
        
    /***
     * @Author Melon
     * @Description 用户评论标签信息资料
     * @Date 16:56 2019/12/27
     * @Param [aimUserId, userId]
     * @Return java.util.List<java.lang.String>
     **/
    List<String> userCommentLabel(@Param("aimUserId") Integer aimUserId);
}