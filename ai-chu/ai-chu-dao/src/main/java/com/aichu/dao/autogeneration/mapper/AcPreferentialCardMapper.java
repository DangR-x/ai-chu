package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcPreferentialCardDO;
import com.aichu.dao.autogeneration.object.AcPreferentialCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcPreferentialCardMapper {
    long countByExample(AcPreferentialCardExample example);

    int deleteByExample(AcPreferentialCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcPreferentialCardDO record);

    int insertSelective(AcPreferentialCardDO record);

    List<AcPreferentialCardDO> selectByExampleWithRowbounds(AcPreferentialCardExample example, RowBounds rowBounds);

    List<AcPreferentialCardDO> selectByExample(AcPreferentialCardExample example);

    AcPreferentialCardDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcPreferentialCardDO record, @Param("example") AcPreferentialCardExample example);

    int updateByExample(@Param("record") AcPreferentialCardDO record, @Param("example") AcPreferentialCardExample example);

    int updateByPrimaryKeySelective(AcPreferentialCardDO record);

    int updateByPrimaryKey(AcPreferentialCardDO record);
}