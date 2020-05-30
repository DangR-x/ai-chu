package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcChartGoodsDO;
import com.aichu.dao.autogeneration.object.AcChartGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcChartGoodsMapper {
    long countByExample(AcChartGoodsExample example);

    int deleteByExample(AcChartGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcChartGoodsDO record);

    int insertSelective(AcChartGoodsDO record);

    List<AcChartGoodsDO> selectByExampleWithRowbounds(AcChartGoodsExample example, RowBounds rowBounds);

    List<AcChartGoodsDO> selectByExample(AcChartGoodsExample example);

    AcChartGoodsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcChartGoodsDO record, @Param("example") AcChartGoodsExample example);

    int updateByExample(@Param("record") AcChartGoodsDO record, @Param("example") AcChartGoodsExample example);

    int updateByPrimaryKeySelective(AcChartGoodsDO record);

    int updateByPrimaryKey(AcChartGoodsDO record);
}