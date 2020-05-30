package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysLabelDO;
import com.aichu.dao.autogeneration.object.AcSysLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysLabelMapper {
    long countByExample(AcSysLabelExample example);

    int deleteByExample(AcSysLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysLabelDO record);

    int insertSelective(AcSysLabelDO record);

    List<AcSysLabelDO> selectByExampleWithRowbounds(AcSysLabelExample example, RowBounds rowBounds);

    List<AcSysLabelDO> selectByExample(AcSysLabelExample example);

    AcSysLabelDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysLabelDO record, @Param("example") AcSysLabelExample example);

    int updateByExample(@Param("record") AcSysLabelDO record, @Param("example") AcSysLabelExample example);

    int updateByPrimaryKeySelective(AcSysLabelDO record);

    int updateByPrimaryKey(AcSysLabelDO record);
}