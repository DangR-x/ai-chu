package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.dao.autogeneration.object.AcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserMapper {
    long countByExample(AcUserExample example);

    int deleteByExample(AcUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserDO record);

    int insertSelective(AcUserDO record);

    List<AcUserDO> selectByExampleWithRowbounds(AcUserExample example, RowBounds rowBounds);

    List<AcUserDO> selectByExample(AcUserExample example);

    AcUserDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserDO record, @Param("example") AcUserExample example);

    int updateByExample(@Param("record") AcUserDO record, @Param("example") AcUserExample example);

    int updateByPrimaryKeySelective(AcUserDO record);

    int updateByPrimaryKey(AcUserDO record);
}