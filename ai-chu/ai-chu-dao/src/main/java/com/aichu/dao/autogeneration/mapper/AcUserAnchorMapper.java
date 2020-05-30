package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserAnchorDO;
import com.aichu.dao.autogeneration.object.AcUserAnchorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserAnchorMapper {
    long countByExample(AcUserAnchorExample example);

    int deleteByExample(AcUserAnchorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserAnchorDO record);

    int insertSelective(AcUserAnchorDO record);

    List<AcUserAnchorDO> selectByExampleWithRowbounds(AcUserAnchorExample example, RowBounds rowBounds);

    List<AcUserAnchorDO> selectByExample(AcUserAnchorExample example);

    AcUserAnchorDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserAnchorDO record, @Param("example") AcUserAnchorExample example);

    int updateByExample(@Param("record") AcUserAnchorDO record, @Param("example") AcUserAnchorExample example);

    int updateByPrimaryKeySelective(AcUserAnchorDO record);

    int updateByPrimaryKey(AcUserAnchorDO record);
}