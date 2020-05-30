package com.aichu.admin.shiros.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aichu.common.util.api.ApiResult;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yuan,shuai
 * @create 2019/7/20
 */
public class SysLogoutFilter extends LogoutFilter {

    private static Logger logger = LoggerFactory.getLogger(SysLogoutFilter.class);

    /**
     * 退出登录拦截调用
     *
     * @param request
     * @param response
     * @return Boolean
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("退出");
        Subject subject = getSubject(request, response);
        try {
            subject.logout();
        } catch (SessionException ise) {
            logger.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        ApiResult result = ApiResult.success();
        String resultJson = JSON.toJSONString(result,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        httpServletResponse.getWriter().write(resultJson);
        return false;
    }
}
