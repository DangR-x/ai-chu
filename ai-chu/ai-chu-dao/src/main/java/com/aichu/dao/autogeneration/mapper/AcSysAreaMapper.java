package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysAreaDO;
import com.aichu.dao.autogeneration.object.AcSysAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysAreaMapper {
    long countByExample(AcSysAreaExample example);

    int deleteByExample(AcSysAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysAreaDO record);

    int insertSelective(AcSysAreaDO record);

    List<AcSysAreaDO> selectByExampleWithRowbounds(AcSysAreaExample example, RowBounds rowBounds);

    List<AcSysAreaDO> selectByExample(AcSysAreaExample example);

    AcSysAreaDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysAreaDO record, @Param("example") AcSysAreaExample example);

    int updateByExample(@Param("record") AcSysAreaDO record, @Param("example") AcSysAreaExample example);

    int updateByPrimaryKeySelective(AcSysAreaDO record);

    int updateByPrimaryKey(AcSysAreaDO record);
}