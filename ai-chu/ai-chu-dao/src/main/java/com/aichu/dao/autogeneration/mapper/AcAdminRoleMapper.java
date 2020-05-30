package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminRoleDO;
import com.aichu.dao.autogeneration.object.AcAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminRoleMapper {
    long countByExample(AcAdminRoleExample example);

    int deleteByExample(AcAdminRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminRoleDO record);

    int insertSelective(AcAdminRoleDO record);

    List<AcAdminRoleDO> selectByExampleWithRowbounds(AcAdminRoleExample example, RowBounds rowBounds);

    List<AcAdminRoleDO> selectByExample(AcAdminRoleExample example);

    AcAdminRoleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminRoleDO record, @Param("example") AcAdminRoleExample example);

    int updateByExample(@Param("record") AcAdminRoleDO record, @Param("example") AcAdminRoleExample example);

    int updateByPrimaryKeySelective(AcAdminRoleDO record);

    int updateByPrimaryKey(AcAdminRoleDO record);
}