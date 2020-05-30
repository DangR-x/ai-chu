package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserMessageReadDO;
import com.aichu.dao.autogeneration.object.AcUserMessageReadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserMessageReadMapper {
    long countByExample(AcUserMessageReadExample example);

    int deleteByExample(AcUserMessageReadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserMessageReadDO record);

    int insertSelective(AcUserMessageReadDO record);

    List<AcUserMessageReadDO> selectByExampleWithRowbounds(AcUserMessageReadExample example, RowBounds rowBounds);

    List<AcUserMessageReadDO> selectByExample(AcUserMessageReadExample example);

    AcUserMessageReadDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserMessageReadDO record, @Param("example") AcUserMessageReadExample example);

    int updateByExample(@Param("record") AcUserMessageReadDO record, @Param("example") AcUserMessageReadExample example);

    int updateByPrimaryKeySelective(AcUserMessageReadDO record);

    int updateByPrimaryKey(AcUserMessageReadDO record);
}