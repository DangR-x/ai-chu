package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserPhotoAlbumDO;
import com.aichu.dao.autogeneration.object.AcUserPhotoAlbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserPhotoAlbumMapper {
    long countByExample(AcUserPhotoAlbumExample example);

    int deleteByExample(AcUserPhotoAlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserPhotoAlbumDO record);

    int insertSelective(AcUserPhotoAlbumDO record);

    List<AcUserPhotoAlbumDO> selectByExampleWithRowbounds(AcUserPhotoAlbumExample example, RowBounds rowBounds);

    List<AcUserPhotoAlbumDO> selectByExample(AcUserPhotoAlbumExample example);

    AcUserPhotoAlbumDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserPhotoAlbumDO record, @Param("example") AcUserPhotoAlbumExample example);

    int updateByExample(@Param("record") AcUserPhotoAlbumDO record, @Param("example") AcUserPhotoAlbumExample example);

    int updateByPrimaryKeySelective(AcUserPhotoAlbumDO record);

    int updateByPrimaryKey(AcUserPhotoAlbumDO record);
}