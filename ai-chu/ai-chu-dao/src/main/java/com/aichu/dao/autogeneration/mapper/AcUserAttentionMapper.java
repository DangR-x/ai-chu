package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserAttentionDO;
import com.aichu.dao.autogeneration.object.AcUserAttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserAttentionMapper {
    long countByExample(AcUserAttentionExample example);

    int deleteByExample(AcUserAttentionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserAttentionDO record);

    int insertSelective(AcUserAttentionDO record);

    List<AcUserAttentionDO> selectByExampleWithRowbounds(AcUserAttentionExample example, RowBounds rowBounds);

    List<AcUserAttentionDO> selectByExample(AcUserAttentionExample example);

    AcUserAttentionDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserAttentionDO record, @Param("example") AcUserAttentionExample example);

    int updateByExample(@Param("record") AcUserAttentionDO record, @Param("example") AcUserAttentionExample example);

    int updateByPrimaryKeySelective(AcUserAttentionDO record);

    int updateByPrimaryKey(AcUserAttentionDO record);
}