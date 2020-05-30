package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName AcAdminUserDaoMapper
 * @Author yuan.shuai
 * @Description 后台用户Mapper
 * @Date 2019/7/19
 * @Version 1.0.0
 */
public interface AcAdminUserDaoMapper {

    /**
     * @Description 通过后台用户名查询 后台用户
     * @param userName
     * @return AcAdminUserDao
     */
    AcAdminUserDao getAdminUserToUserName(@Param("userName") String userName);

    /**
     * @Description 管理员列表查询
     * @Param name,type
     * @Return List<AcAdminUserDao>
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    List<AcAdminUserDao> getAdminUserList(@Param("name") String name);

    /**
     * @Description 后台管理员编辑查询
     * @Param UserId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/7/30
     * @Version 1.0.0
     */
    EditorAdminUserBackDao getEditorAdminUserBackDetail(@Param("userId") Integer userId);

    /**
     * @Description 后台管理员查看详情
     * @Param userId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/7/30
     * @Version 1.0.0
     */
    AdminUserBackDetailDao getAdminUserBackDetail(@Param("userId") Integer userId);

    /**
     * @Description 校验后台用户昵称是否存在
     * @Param aliasName
     * @Return Integer
     * @Author yuan.shuai
     * @Date  2019/8/3
     * @Version 1.0.0
     */
    Integer checkAdminUserAliasNameIsExist(@Param("aliasName") String aliasName);
}