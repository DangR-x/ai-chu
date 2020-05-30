package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysConfigDO;
import com.aichu.dao.autogeneration.object.AcSysConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysConfigMapper {
    long countByExample(AcSysConfigExample example);

    int deleteByExample(AcSysConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysConfigDO record);

    int insertSelective(AcSysConfigDO record);

    List<AcSysConfigDO> selectByExampleWithBLOBsWithRowbounds(AcSysConfigExample example, RowBounds rowBounds);

    List<AcSysConfigDO> selectByExampleWithBLOBs(AcSysConfigExample example);

    List<AcSysConfigDO> selectByExampleWithRowbounds(AcSysConfigExample example, RowBounds rowBounds);

    List<AcSysConfigDO> selectByExample(AcSysConfigExample example);

    AcSysConfigDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysConfigDO record, @Param("example") AcSysConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") AcSysConfigDO record, @Param("example") AcSysConfigExample example);

    int updateByExample(@Param("record") AcSysConfigDO record, @Param("example") AcSysConfigExample example);

    int updateByPrimaryKeySelective(AcSysConfigDO record);

    int updateByPrimaryKeyWithBLOBs(AcSysConfigDO record);

    int updateByPrimaryKey(AcSysConfigDO record);
}