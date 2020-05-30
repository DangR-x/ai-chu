package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcChartGoodsRecordDO;
import com.aichu.dao.autogeneration.object.AcChartGoodsRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcChartGoodsRecordMapper {
    long countByExample(AcChartGoodsRecordExample example);

    int deleteByExample(AcChartGoodsRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcChartGoodsRecordDO record);

    int insertSelective(AcChartGoodsRecordDO record);

    List<AcChartGoodsRecordDO> selectByExampleWithRowbounds(AcChartGoodsRecordExample example, RowBounds rowBounds);

    List<AcChartGoodsRecordDO> selectByExample(AcChartGoodsRecordExample example);

    AcChartGoodsRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcChartGoodsRecordDO record, @Param("example") AcChartGoodsRecordExample example);

    int updateByExample(@Param("record") AcChartGoodsRecordDO record, @Param("example") AcChartGoodsRecordExample example);

    int updateByPrimaryKeySelective(AcChartGoodsRecordDO record);

    int updateByPrimaryKey(AcChartGoodsRecordDO record);
}