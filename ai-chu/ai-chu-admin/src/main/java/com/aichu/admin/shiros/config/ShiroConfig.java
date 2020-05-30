package com.aichu.admin.shiros.config;

import com.aichu.admin.shiros.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * @author yuanshuai
 * @date 2019/8/29
 */
@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        logger.info("Shiro路径拦截");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.getFilters().put("logout", new SysLogoutFilter()); // 注入退出过滤器
        shiroFilterFactoryBean.getFilters().put("authc",new UserFilter(redisSessionDao().redisTemplate));//认证拦截
        // 设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 设置登录路径
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/home");
        // 权限控制map.
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        //filterChainDefinitionMap.put("/**","anon"); //开发中使用
        filterChainDefinitionMap.put("/swagger-ui.html", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/swagger-resources/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
        filterChainDefinitionMap.put("/error", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/css/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/js/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/http/**", "anon");
        filterChainDefinitionMap.put("/admin/user/logout","logout");
        filterChainDefinitionMap.put("/admin/user/login","anon");
        //filterChainDefinitionMap.put("/admin/builder/**","anon");
        filterChainDefinitionMap.put("/temple/manger/**","anon");
        filterChainDefinitionMap.put("/**","authc"); // 认证所有路径
        //自定义加载权限资源关系 TODO 从数据库读路径配置
//        List<Resources> resourcesList = resourcesService.queryAll();
//        for(Resources resources:resourcesList){
//
//            if (StringUtil.isNotEmpty(resources.getResurl())) {
//                String permission = "perms[" + resources.getResurl()+ "]";
//                filterChainDefinitionMap.put(resources.getResurl(),permission);
//            }
//        }
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean("securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        securityManager.setRememberMeManager(rememberMeManager());
        //securityManager.setCacheManager(redisCacheManager());
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * @Description 配置shiro redisManager
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    @Bean
    public RedisSessionManager sessionManager(){
        RedisSessionManager redisSessionManager = new RedisSessionManager();
        redisSessionManager.setSessionDAO(redisSessionDao());
        return redisSessionManager;
    }

    /**
     * @Description 通过redis RedisSessionDAO shiro sessionDao层的实现 使用shiro-redis插件
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    @Bean
    public RedisSessionDao redisSessionDao(){
        RedisSessionDao redisSessionDao = new RedisSessionDao();
        redisSessionDao.setTimeout(RedisSessionDao.DEFAILT_TIME_OUT);
        return new RedisSessionDao();
    }

    /**
     * @Description cacheManager 缓存 redis实现 (目前没有使用缓存)
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    @Bean
     public RedisCacheManager redisCacheManager(){
        return new RedisCacheManager();
     }

    /**
     * cookie对象;
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        logger.info("rememberMeCookie()");
        // 这个参数是cookie的名称，对应前端的checkbox 的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // <!-- 记住我cookie生效时间1小时（360） ,单位秒;-->
        simpleCookie.setMaxAge(3600);
        return simpleCookie;
    }

    /**
     * 记住我管理器 cookie管理对象;
     *
     * @return
     */
    @Bean(name = "cookieRememberMeManager")
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * 系统自带的Realm管理，主要针对多realm
     * */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

    /**
     * 需要密码登录的realm
     *
     * @return MyShiroRealm
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     *  所以我们需要修改下doGetAuthenticationInfo中的代码;
     * ）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        //hashedCredentialsMatcher.setHashIterations(1);//散列的次数，md5("")
        return hashedCredentialsMatcher;
    }



    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    /** * Shiro生命周期处理器 * @return */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        logger.info("开启Shiro注解方式");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
}