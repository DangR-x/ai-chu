package com.aichu.service.api;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.AcLabelQeuryDTO;
import com.aichu.service.dto.AcSysLabelDTO;
import com.aichu.service.dto.AcSysLabelSelectDTO;
import com.aichu.service.dto.LabelDictDTO;

import java.util.List;

/**
 * @ClassName AcSysBannerService
 * @Description 系统表情信息Service
 * @Author Melon
 * @Date 2019/7/23 11:41
 * @Version 1.0.0
 **/
public interface AcSysLabelService {

    /***
     * @Author Melon
     * @Description 标签字典信息列表
     * @Date 18:38 2019/12/26
     * @Param test
     * @Return java.util.List<com.aichu.service.dto.LabelDictDTO>
     **/
    List<LabelDictDTO> labelDictList(Integer labelType) throws Exception;

    /**
     * @Description 后台活动标签（下拉框）
     * @Return java.util.List<AcSysLabelSelectDTO>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    List<AcSysLabelSelectDTO> getLabelSelectList() throws Exception;

    /**
     * @Description 后台系统标签库信息列表查询
     * @Param AcLabelQeuryDTO
     * @Return BaseResponse<List<AcSysLabelDTO>>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    BaseResponse<List<AcSysLabelDTO>> getLableBackList(AcLabelQeuryDTO qeuryDTO) throws Exception;

    /**
     * @Description 后台系统标签库删除
     * @Param id
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    Boolean deleteLabel(Integer id) throws Exception;

    /**
     * @Description 后台系统标签库修改
     * @Param YjzhSysLabelDTO
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    Boolean updateOrAddLabelDetail(AcSysLabelDTO wzSysLabelDTO) throws Exception;
}
