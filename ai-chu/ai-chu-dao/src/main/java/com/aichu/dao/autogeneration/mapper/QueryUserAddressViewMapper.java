package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.QueryUserAddressViewDO;
import com.aichu.dao.autogeneration.object.QueryUserAddressViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface QueryUserAddressViewMapper {
    long countByExample(QueryUserAddressViewExample example);

    int deleteByExample(QueryUserAddressViewExample example);

    int insert(QueryUserAddressViewDO record);

    int insertSelective(QueryUserAddressViewDO record);

    List<QueryUserAddressViewDO> selectByExampleWithBLOBsWithRowbounds(QueryUserAddressViewExample example, RowBounds rowBounds);

    List<QueryUserAddressViewDO> selectByExampleWithBLOBs(QueryUserAddressViewExample example);

    List<QueryUserAddressViewDO> selectByExampleWithRowbounds(QueryUserAddressViewExample example, RowBounds rowBounds);

    List<QueryUserAddressViewDO> selectByExample(QueryUserAddressViewExample example);

    int updateByExampleSelective(@Param("record") QueryUserAddressViewDO record, @Param("example") QueryUserAddressViewExample example);

    int updateByExampleWithBLOBs(@Param("record") QueryUserAddressViewDO record, @Param("example") QueryUserAddressViewExample example);

    int updateByExample(@Param("record") QueryUserAddressViewDO record, @Param("example") QueryUserAddressViewExample example);
}