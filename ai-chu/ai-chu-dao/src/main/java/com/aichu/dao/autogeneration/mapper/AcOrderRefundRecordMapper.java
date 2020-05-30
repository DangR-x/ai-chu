package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcOrderRefundRecordDO;
import com.aichu.dao.autogeneration.object.AcOrderRefundRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcOrderRefundRecordMapper {
    long countByExample(AcOrderRefundRecordExample example);

    int deleteByExample(AcOrderRefundRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcOrderRefundRecordDO record);

    int insertSelective(AcOrderRefundRecordDO record);

    List<AcOrderRefundRecordDO> selectByExampleWithRowbounds(AcOrderRefundRecordExample example, RowBounds rowBounds);

    List<AcOrderRefundRecordDO> selectByExample(AcOrderRefundRecordExample example);

    AcOrderRefundRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcOrderRefundRecordDO record, @Param("example") AcOrderRefundRecordExample example);

    int updateByExample(@Param("record") AcOrderRefundRecordDO record, @Param("example") AcOrderRefundRecordExample example);

    int updateByPrimaryKeySelective(AcOrderRefundRecordDO record);

    int updateByPrimaryKey(AcOrderRefundRecordDO record);
}