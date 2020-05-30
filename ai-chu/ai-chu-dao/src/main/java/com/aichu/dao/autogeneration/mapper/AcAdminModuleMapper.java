package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminModuleDO;
import com.aichu.dao.autogeneration.object.AcAdminModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminModuleMapper {
    long countByExample(AcAdminModuleExample example);

    int deleteByExample(AcAdminModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminModuleDO record);

    int insertSelective(AcAdminModuleDO record);

    List<AcAdminModuleDO> selectByExampleWithRowbounds(AcAdminModuleExample example, RowBounds rowBounds);

    List<AcAdminModuleDO> selectByExample(AcAdminModuleExample example);

    AcAdminModuleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminModuleDO record, @Param("example") AcAdminModuleExample example);

    int updateByExample(@Param("record") AcAdminModuleDO record, @Param("example") AcAdminModuleExample example);

    int updateByPrimaryKeySelective(AcAdminModuleDO record);

    int updateByPrimaryKey(AcAdminModuleDO record);
}