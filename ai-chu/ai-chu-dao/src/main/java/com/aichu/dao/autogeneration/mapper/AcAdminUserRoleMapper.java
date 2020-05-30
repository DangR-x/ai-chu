package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminUserRoleDO;
import com.aichu.dao.autogeneration.object.AcAdminUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminUserRoleMapper {
    long countByExample(AcAdminUserRoleExample example);

    int deleteByExample(AcAdminUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminUserRoleDO record);

    int insertSelective(AcAdminUserRoleDO record);

    List<AcAdminUserRoleDO> selectByExampleWithRowbounds(AcAdminUserRoleExample example, RowBounds rowBounds);

    List<AcAdminUserRoleDO> selectByExample(AcAdminUserRoleExample example);

    AcAdminUserRoleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminUserRoleDO record, @Param("example") AcAdminUserRoleExample example);

    int updateByExample(@Param("record") AcAdminUserRoleDO record, @Param("example") AcAdminUserRoleExample example);

    int updateByPrimaryKeySelective(AcAdminUserRoleDO record);

    int updateByPrimaryKey(AcAdminUserRoleDO record);
}