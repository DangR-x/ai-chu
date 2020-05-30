package com.aichu.app.config.bean;

import com.aichu.app.authorization.jwt.JwtTokenValidator;
import com.aichu.app.authorization.resolver.UserRepository;
import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.auth.interceptor.AuthorizationInterceptor;
import com.aichu.common.util.auth.manager.TokenManager;
import com.aichu.common.util.auth.manager.impl.RedisTokenManager;
import com.aichu.common.util.auth.resolvers.MyMethodArgumentResolver;
import com.aichu.app.config.redis.TokenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @ClassName BeanFactory
 * @Description BeanFactory
 * @Author Melon
 * @Date 2019/7/19 10:34
 * @Version 1.0.0
 **/
@Component
public class BeanFactory {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenConfig tokenConfig;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JwtTokenValidator tokenValidator;

    /***
     * @Author Melon
     * @Description 用户对象解析器
     * @Date 10:21 2019/7/19
     * @Param []
     * @Return MyMethodArgumentResolver<MemberRequestDao>
     **/
    @Bean
    public MyMethodArgumentResolver<AcUserRequestDao> getCurrentUserMethodArgumentResolver() {
        MyMethodArgumentResolver<AcUserRequestDao> currentUserMethodArgumentResolver = new MyMethodArgumentResolver<>();
        currentUserMethodArgumentResolver.setModelClass(AcUserRequestDao.class);
        currentUserMethodArgumentResolver.setModelRepository(userRepository);
        currentUserMethodArgumentResolver.setCurrAnnotationClass(CurrentUser.class);
        currentUserMethodArgumentResolver.setCallFunc(webRequest ->
                String.valueOf(webRequest.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY, RequestAttributes.SCOPE_REQUEST))
        );
        return currentUserMethodArgumentResolver;
    }

    /***
     * @Author Melon
     * @Description Redis管理器
     * @Date 10:21 2019/7/19
     * @Param []
     * @Return com.wenzu.common.util.auth.manager.TokenManager
     **/
    @Bean(name = "tokenManager")
    public TokenManager getTokenManager() {
        RedisTokenManager redisTokenManager = new RedisTokenManager();
        redisTokenManager.setStringRedisTemplate(stringRedisTemplate);
        redisTokenManager.setTokenExpireSeconds(tokenConfig.getTokenExpireSeconds());
        redisTokenManager.setSingleTokenWithUser(tokenConfig.getSingleTokenWithUser());
        redisTokenManager.setFlushExpireAfterOperation(tokenConfig.getFlushExpireAfterOperation());
        return redisTokenManager;
    }
    
    /***
     * @Author Melon
     * @Description 权限验证管理器
     * @Date 10:21 2019/7/19
     * @Param [tokenManager]
     * @Return com.wenzu.common.util.auth.interceptor.AuthorizationInterceptor
     **/
    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor(@Qualifier("tokenManager") TokenManager tokenManager) {
        AuthorizationInterceptor authorization = new AuthorizationInterceptor();
        authorization.setManager(tokenManager);
        authorization.setValidator(tokenValidator);
        return authorization;
    }

}
