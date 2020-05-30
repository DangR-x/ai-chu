package com.aichu.admin.shiros.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aichu.common.util.api.ApiResult;
import com.aichu.manager.enums.ResultCodeEnum;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @ClassName UserFilter
 * @Author yuan.shuai
 * @Description 请求验证
 * @Date 2019/8/30
 * @Version 1.0.0
 */
public class UserFilter extends FormAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(UserFilter.class);

    private static final String SESSION_PREFIX = "shiro_session:";

    private RedisTemplate<String, Object> redisTemplate ;

    // 解决实例化对象不能注入RedisTemplate
    public UserFilter(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * @Description 验证请求用户是否登录
     * @Param ServletRequest，ServletResponse，Object
     * @Return boolean
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        logger.info("验证操作用户是否过期/非法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //线上用这个
        String sessionId =  httpServletRequest.getHeader("sessionId");
        //swagger用这个调试
//        String sessionId = httpServletRequest.getHeader("authorization");
        if (Objects.isNull(sessionId) || Objects.equals(sessionId,"undefined")){
            logger.info("SessionId为空，请登录");
            return false;  // 当为false的情况就会执行 onAccessDenied()
        }
        Session session = (Session) redisTemplate.boundValueOps(SESSION_PREFIX + sessionId).get();
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))){
            logger.info("登录已过期，请重新登录");
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        logger.info("操作用户过期/非法");
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        ApiResult  apiResult = ApiResult.error(ResultCodeEnum.LOGIN_TOKEN_EFFICACY.code(),ResultCodeEnum.LOGIN_TOKEN_EFFICACY.getMessage());
        String resultJson = JSON.toJSONString(apiResult,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        httpServletResponse.getWriter().write(resultJson);
        return false;
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
