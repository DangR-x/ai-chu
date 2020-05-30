package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserSignRecordDO;
import com.aichu.dao.autogeneration.object.AcUserSignRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserSignRecordMapper {
    long countByExample(AcUserSignRecordExample example);

    int deleteByExample(AcUserSignRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserSignRecordDO record);

    int insertSelective(AcUserSignRecordDO record);

    List<AcUserSignRecordDO> selectByExampleWithRowbounds(AcUserSignRecordExample example, RowBounds rowBounds);

    List<AcUserSignRecordDO> selectByExample(AcUserSignRecordExample example);

    AcUserSignRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserSignRecordDO record, @Param("example") AcUserSignRecordExample example);

    int updateByExample(@Param("record") AcUserSignRecordDO record, @Param("example") AcUserSignRecordExample example);

    int updateByPrimaryKeySelective(AcUserSignRecordDO record);

    int updateByPrimaryKey(AcUserSignRecordDO record);
}