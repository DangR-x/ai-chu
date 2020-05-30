package com.aichu.service.api.impl;

import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcUserScoreMapper;
import com.aichu.dao.autogeneration.object.AcUserScoreDO;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.service.api.AcUserScoreService;
import com.aichu.service.dto.UserCommentScoreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AcUserScoreServiceImpl
 * @Description 用户评论信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/23 11:40
 * @Version 1.0.0
 **/
@Service
public class AcUserScoreServiceImpl implements AcUserScoreService {

    private Logger logger = LoggerFactory.getLogger(AcUserScoreServiceImpl.class);

    @Autowired
    private AcUserScoreMapper acUserScoreMapper;

    @Override
    public Boolean anchorCommentScore(UserCommentScoreDTO userCommentScoreDTO, Integer userId) throws Exception {
        logger.info("-----------用户评论主播信息-------Start：userCommentScoreDTO：--{}, userId：--{}", userCommentScoreDTO, userId);

        AcUserScoreDO acUserScoreDO = new AcUserScoreDO();
        acUserScoreDO.setAimUserId(userCommentScoreDTO.getAimUserId());
        acUserScoreDO.setCommentLevel(userCommentScoreDTO.getCommentScore());
        acUserScoreDO.setCommentLableId(userCommentScoreDTO.getCommentScoreLabelId());
        acUserScoreDO.setCommentUserId(userId);
        Integer result = acUserScoreMapper.insertSelective(acUserScoreDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.AIM_USER_COMMENT_FILED.code(), ResultCodeEnum.AIM_USER_COMMENT_FILED.message());
        }

        logger.info("-----------用户评论主播信息-------End");
        return true;
    }
}
