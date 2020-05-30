package com.aichu.common.util.auth.interceptor;

import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.common.util.auth.manager.TokenManager;
import com.aichu.common.util.auth.manager.TokenValidator;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName AuthorizationInterceptor
 * @Description 自定义拦截器，对请求进行身份验证
 * @Author Melon
 * @Date 2019/7/19 10:19
 * @Version 1.0.0
 **/
public class AuthorizationInterceptor implements HandlerInterceptor {

    /**
     * 存放登录用户模型Key的Request Key
     */
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    // 管理身份验证操作的对象
    private TokenManager manager;

    // Token验证器
    private TokenValidator validator;

    // 存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    // 鉴权信息的无用前缀，默认为空
    private String httpHeaderPrefix = "";

    // 鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    // 鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    public void setManager(TokenManager manager) {
        this.manager = manager;
    }

    public void setValidator(TokenValidator validator) {
        this.validator = validator;
    }

    public void setHttpHeaderName(String httpHeaderName) {
        this.httpHeaderName = httpHeaderName;
    }

    public void setHttpHeaderPrefix(String httpHeaderPrefix) {
        this.httpHeaderPrefix = httpHeaderPrefix;
    }

    public void setUnauthorizedErrorMessage(String unauthorizedErrorMessage) {
        this.unauthorizedErrorMessage = unauthorizedErrorMessage;
    }

    public void setUnauthorizedErrorCode(int unauthorizedErrorCode) {
        this.unauthorizedErrorCode = unauthorizedErrorCode;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(IgnoreAuthorization.class) == null ) {
            // 从header中得到token 校验token是否存在
            String token = request.getHeader(httpHeaderName);
            if (token != null && token.startsWith(httpHeaderPrefix) && token.length() > 0) {
                token = token.substring(httpHeaderPrefix.length());
                // 验证token
                String key = manager.getKey(token);
                if (validator.validate(token) && key != null) {
                    // 如果token验证成功，将token对应的用户id存在request中，便于之后注入
                    request.setAttribute(REQUEST_CURRENT_KEY, key);
                    return true;
                }
            } else {
                response.setStatus(unauthorizedErrorCode);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                return false;
            }
        }
        // 为了防止以恶意操作直接在REQUEST_CURRENT_KEY写入key，将其设为null
        request.setAttribute(REQUEST_CURRENT_KEY, null);
        return true;
    }
}
