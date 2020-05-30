package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcOrderBaseDO;
import com.aichu.dao.autogeneration.object.AcOrderBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcOrderBaseMapper {
    long countByExample(AcOrderBaseExample example);

    int deleteByExample(AcOrderBaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcOrderBaseDO record);

    int insertSelective(AcOrderBaseDO record);

    List<AcOrderBaseDO> selectByExampleWithRowbounds(AcOrderBaseExample example, RowBounds rowBounds);

    List<AcOrderBaseDO> selectByExample(AcOrderBaseExample example);

    AcOrderBaseDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcOrderBaseDO record, @Param("example") AcOrderBaseExample example);

    int updateByExample(@Param("record") AcOrderBaseDO record, @Param("example") AcOrderBaseExample example);

    int updateByPrimaryKeySelective(AcOrderBaseDO record);

    int updateByPrimaryKey(AcOrderBaseDO record);
}