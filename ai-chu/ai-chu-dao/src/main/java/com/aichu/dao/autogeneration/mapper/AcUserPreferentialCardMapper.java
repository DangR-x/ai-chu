package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserPreferentialCardDO;
import com.aichu.dao.autogeneration.object.AcUserPreferentialCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserPreferentialCardMapper {
    long countByExample(AcUserPreferentialCardExample example);

    int deleteByExample(AcUserPreferentialCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserPreferentialCardDO record);

    int insertSelective(AcUserPreferentialCardDO record);

    List<AcUserPreferentialCardDO> selectByExampleWithRowbounds(AcUserPreferentialCardExample example, RowBounds rowBounds);

    List<AcUserPreferentialCardDO> selectByExample(AcUserPreferentialCardExample example);

    AcUserPreferentialCardDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserPreferentialCardDO record, @Param("example") AcUserPreferentialCardExample example);

    int updateByExample(@Param("record") AcUserPreferentialCardDO record, @Param("example") AcUserPreferentialCardExample example);

    int updateByPrimaryKeySelective(AcUserPreferentialCardDO record);

    int updateByPrimaryKey(AcUserPreferentialCardDO record);
}