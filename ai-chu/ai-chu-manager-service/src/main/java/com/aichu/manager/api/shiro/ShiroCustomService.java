package com.aichu.manager.api.shiro;

import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.workstation.object.AcAdminUserDao;
import com.aichu.manager.enums.ResultCodeEnum;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @ClassName ShiroUtilService
 * @Author yuan.shuai
 * @Description Shiro工具Service
 * @Date 2019/8/30
 * @Version 1.0.0
 */
@Service
public class ShiroCustomService {

    private Logger logger = LoggerFactory.getLogger(ShiroCustomService.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static final String SESSION_PREFIX = "shiro_session:";

    /**
     * @Description 获取请求中的sessionId,然后从redis中获取登录用户的信息
     * @Return  SimplePrincipalCollection （用户信息）
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    public SimplePrincipalCollection getRedisObjectToSessionId() throws Exception{
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String sessionId = request.getHeader("sessionId");
        logger.info("Header中的sessionId:" + sessionId);
        SimplePrincipalCollection simplePrincipalCollection = getRedisObjectToSessionId(sessionId);
        return simplePrincipalCollection;
    }

    /**
     * @Description 通过sessionId获取Redis中存的对象
     * @Param sessionId
     * @Return SimplePrincipalCollection
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    private SimplePrincipalCollection getRedisObjectToSessionId(String sessionId) throws Exception{
        if (Objects.isNull(sessionId) || Objects.equals(sessionId,"")){
            logger.info("sessionId为空，请求非法"); // 用户退出登录，提示 账户异常，请联系管理员
            throw new BusinessException(ResultCodeEnum.LOGIN_TOKEN_EFFICACY.code(),ResultCodeEnum.SYSTEM_ACCOUNT_ERROR.message());
        }
        //Session session = (Session) redisTemplate.boundValueOps(SESSION_PREFIX + sessionId).get();
        Session session = (Session) redisTemplate.boundValueOps(SESSION_PREFIX + sessionId).get();
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))){
            logger.info("获取Session失败,登录信息失效");
            throw new BusinessException(ResultCodeEnum.LOGIN_TOKEN_EFFICACY.code(),ResultCodeEnum.LOGIN_TOKEN_EFFICACY.message());
        }
        SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection)session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        return simplePrincipalCollection;
    }

    /**
     * @Description 获取登录用户的ID
     * @Return  Integer
     * @Author yuan.shuai
     * @Date  2019/11/9
     * @Version 1.1.0
     */
    public Integer getAdminUserIdToSessionId() throws Exception{
        SimplePrincipalCollection simplePrincipalCollection = this.getRedisObjectToSessionId();
        AcAdminUserDao acAdminUserDao = BeanUtil.copy(simplePrincipalCollection.getPrimaryPrincipal(), AcAdminUserDao.class);
        if (Objects.isNull(acAdminUserDao)){
            logger.info("获取Session失败,登录信息失效");
            throw new BusinessException(ResultCodeEnum.LOGIN_TOKEN_EFFICACY.code(),ResultCodeEnum.LOGIN_TOKEN_EFFICACY.message());
        }
        return acAdminUserDao.getId();
    }
}
