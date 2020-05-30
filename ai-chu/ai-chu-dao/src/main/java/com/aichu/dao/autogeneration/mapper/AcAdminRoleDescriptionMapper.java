package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminRoleDescriptionDO;
import com.aichu.dao.autogeneration.object.AcAdminRoleDescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminRoleDescriptionMapper {
    long countByExample(AcAdminRoleDescriptionExample example);

    int deleteByExample(AcAdminRoleDescriptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminRoleDescriptionDO record);

    int insertSelective(AcAdminRoleDescriptionDO record);

    List<AcAdminRoleDescriptionDO> selectByExampleWithRowbounds(AcAdminRoleDescriptionExample example, RowBounds rowBounds);

    List<AcAdminRoleDescriptionDO> selectByExample(AcAdminRoleDescriptionExample example);

    AcAdminRoleDescriptionDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminRoleDescriptionDO record, @Param("example") AcAdminRoleDescriptionExample example);

    int updateByExample(@Param("record") AcAdminRoleDescriptionDO record, @Param("example") AcAdminRoleDescriptionExample example);

    int updateByPrimaryKeySelective(AcAdminRoleDescriptionDO record);

    int updateByPrimaryKey(AcAdminRoleDescriptionDO record);
}