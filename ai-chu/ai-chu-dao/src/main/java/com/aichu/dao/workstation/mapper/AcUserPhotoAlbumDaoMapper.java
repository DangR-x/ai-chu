package com.aichu.dao.workstation.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcUserPhotoAlbumDaoMapper
 * @Description 用户相册信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcUserPhotoAlbumDaoMapper {

    /***
     * @Author Melon
     * @Description 用户相册信息资料
     * @Date 16:56 2019/12/27
     * @Param [aimUserId, userId]
     * @Return java.util.List<java.lang.String>
     **/
    List<String> userPhotoAlbumList(@Param("aimUserId") Integer aimUserId);
}