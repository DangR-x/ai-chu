package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysBannerDO;
import com.aichu.dao.autogeneration.object.AcSysBannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysBannerMapper {
    long countByExample(AcSysBannerExample example);

    int deleteByExample(AcSysBannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysBannerDO record);

    int insertSelective(AcSysBannerDO record);

    List<AcSysBannerDO> selectByExampleWithRowbounds(AcSysBannerExample example, RowBounds rowBounds);

    List<AcSysBannerDO> selectByExample(AcSysBannerExample example);

    AcSysBannerDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysBannerDO record, @Param("example") AcSysBannerExample example);

    int updateByExample(@Param("record") AcSysBannerDO record, @Param("example") AcSysBannerExample example);

    int updateByPrimaryKeySelective(AcSysBannerDO record);

    int updateByPrimaryKey(AcSysBannerDO record);
}