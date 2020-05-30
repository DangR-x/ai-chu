package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysCityDO;
import com.aichu.dao.autogeneration.object.AcSysCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysCityMapper {
    long countByExample(AcSysCityExample example);

    int deleteByExample(AcSysCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysCityDO record);

    int insertSelective(AcSysCityDO record);

    List<AcSysCityDO> selectByExampleWithRowbounds(AcSysCityExample example, RowBounds rowBounds);

    List<AcSysCityDO> selectByExample(AcSysCityExample example);

    AcSysCityDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysCityDO record, @Param("example") AcSysCityExample example);

    int updateByExample(@Param("record") AcSysCityDO record, @Param("example") AcSysCityExample example);

    int updateByPrimaryKeySelective(AcSysCityDO record);

    int updateByPrimaryKey(AcSysCityDO record);
}