package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcOrderPayRecordDO;
import com.aichu.dao.autogeneration.object.AcOrderPayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcOrderPayRecordMapper {
    long countByExample(AcOrderPayRecordExample example);

    int deleteByExample(AcOrderPayRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcOrderPayRecordDO record);

    int insertSelective(AcOrderPayRecordDO record);

    List<AcOrderPayRecordDO> selectByExampleWithRowbounds(AcOrderPayRecordExample example, RowBounds rowBounds);

    List<AcOrderPayRecordDO> selectByExample(AcOrderPayRecordExample example);

    AcOrderPayRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcOrderPayRecordDO record, @Param("example") AcOrderPayRecordExample example);

    int updateByExample(@Param("record") AcOrderPayRecordDO record, @Param("example") AcOrderPayRecordExample example);

    int updateByPrimaryKeySelective(AcOrderPayRecordDO record);

    int updateByPrimaryKey(AcOrderPayRecordDO record);
}