package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminModuleJurDO;
import com.aichu.dao.autogeneration.object.AcAdminModuleJurExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminModuleJurMapper {
    long countByExample(AcAdminModuleJurExample example);

    int deleteByExample(AcAdminModuleJurExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminModuleJurDO record);

    int insertSelective(AcAdminModuleJurDO record);

    List<AcAdminModuleJurDO> selectByExampleWithRowbounds(AcAdminModuleJurExample example, RowBounds rowBounds);

    List<AcAdminModuleJurDO> selectByExample(AcAdminModuleJurExample example);

    AcAdminModuleJurDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminModuleJurDO record, @Param("example") AcAdminModuleJurExample example);

    int updateByExample(@Param("record") AcAdminModuleJurDO record, @Param("example") AcAdminModuleJurExample example);

    int updateByPrimaryKeySelective(AcAdminModuleJurDO record);

    int updateByPrimaryKey(AcAdminModuleJurDO record);
}