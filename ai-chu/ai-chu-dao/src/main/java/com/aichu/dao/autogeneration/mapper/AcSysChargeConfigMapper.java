package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysChargeConfigDO;
import com.aichu.dao.autogeneration.object.AcSysChargeConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysChargeConfigMapper {
    long countByExample(AcSysChargeConfigExample example);

    int deleteByExample(AcSysChargeConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysChargeConfigDO record);

    int insertSelective(AcSysChargeConfigDO record);

    List<AcSysChargeConfigDO> selectByExampleWithRowbounds(AcSysChargeConfigExample example, RowBounds rowBounds);

    List<AcSysChargeConfigDO> selectByExample(AcSysChargeConfigExample example);

    AcSysChargeConfigDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysChargeConfigDO record, @Param("example") AcSysChargeConfigExample example);

    int updateByExample(@Param("record") AcSysChargeConfigDO record, @Param("example") AcSysChargeConfigExample example);

    int updateByPrimaryKeySelective(AcSysChargeConfigDO record);

    int updateByPrimaryKey(AcSysChargeConfigDO record);
}