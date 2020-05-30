package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcAdminRoleDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcAdminUserRoleDaoMapper
 * @Author yuan.shuai
 * @Description 后台用户角色中间表Mapper
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public interface AcAdminUserRoleDaoMapper {

    List<AcAdminRoleDao> getRoleToUserId(@Param("userId") Integer userId);
}