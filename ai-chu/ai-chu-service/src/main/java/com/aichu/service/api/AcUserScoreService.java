package com.aichu.service.api;

import com.aichu.service.dto.UserCommentScoreDTO;

/**
 * @ClassName AcUserScoreService
 * @Description 用户评论信息Service
 * @Author Melon
 * @Date 2019/7/23 11:41
 * @Version 1.0.0
 **/
public interface AcUserScoreService {

    /***
     * @Author Melon
     * @Description 用户评论主播信息
     * @Date 10:01 2019/12/31
     * @Param [userCommentScoreDTO, userId]
     * @Return java.lang.Boolean
     **/
    Boolean anchorCommentScore(UserCommentScoreDTO userCommentScoreDTO, Integer userId) throws Exception;

}
