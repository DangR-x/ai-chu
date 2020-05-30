package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcOrderWithdrawDO;
import com.aichu.dao.autogeneration.object.AcOrderWithdrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcOrderWithdrawMapper {
    long countByExample(AcOrderWithdrawExample example);

    int deleteByExample(AcOrderWithdrawExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcOrderWithdrawDO record);

    int insertSelective(AcOrderWithdrawDO record);

    List<AcOrderWithdrawDO> selectByExampleWithRowbounds(AcOrderWithdrawExample example, RowBounds rowBounds);

    List<AcOrderWithdrawDO> selectByExample(AcOrderWithdrawExample example);

    AcOrderWithdrawDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcOrderWithdrawDO record, @Param("example") AcOrderWithdrawExample example);

    int updateByExample(@Param("record") AcOrderWithdrawDO record, @Param("example") AcOrderWithdrawExample example);

    int updateByPrimaryKeySelective(AcOrderWithdrawDO record);

    int updateByPrimaryKey(AcOrderWithdrawDO record);
}