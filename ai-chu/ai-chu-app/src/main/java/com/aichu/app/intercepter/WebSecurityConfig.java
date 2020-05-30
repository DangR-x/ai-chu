package com.aichu.app.intercepter;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.common.util.auth.interceptor.AuthorizationInterceptor;
import com.aichu.common.util.auth.resolvers.MyMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName WebSecurityConfig
 * @Description WebSecurityConfig
 * @Author Melon
 * @Date 2019/7/19 15:25
 * @Version 1.0.0
 **/
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private MyMethodArgumentResolver<AcUserRequestDao> currentUserMethodArgumentResolver;

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    /**
     * 不需要认证的地址
     */
    private static String[] unInterceptor = new String[] {
            "/swagger-resources/**",
            "/account/login**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registrationInterceptor = registry.addInterceptor(authorizationInterceptor);
        registrationInterceptor.excludePathPatterns(unInterceptor);
        registrationInterceptor.addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver);
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
