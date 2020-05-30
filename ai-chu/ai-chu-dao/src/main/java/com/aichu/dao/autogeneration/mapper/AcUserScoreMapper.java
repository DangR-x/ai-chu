package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserScoreDO;
import com.aichu.dao.autogeneration.object.AcUserScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserScoreMapper {
    long countByExample(AcUserScoreExample example);

    int deleteByExample(AcUserScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserScoreDO record);

    int insertSelective(AcUserScoreDO record);

    List<AcUserScoreDO> selectByExampleWithRowbounds(AcUserScoreExample example, RowBounds rowBounds);

    List<AcUserScoreDO> selectByExample(AcUserScoreExample example);

    AcUserScoreDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserScoreDO record, @Param("example") AcUserScoreExample example);

    int updateByExample(@Param("record") AcUserScoreDO record, @Param("example") AcUserScoreExample example);

    int updateByPrimaryKeySelective(AcUserScoreDO record);

    int updateByPrimaryKey(AcUserScoreDO record);
}