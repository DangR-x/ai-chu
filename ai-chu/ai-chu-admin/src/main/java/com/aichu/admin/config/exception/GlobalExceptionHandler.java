package com.aichu.admin.config.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientException;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.common.util.exception.ParamReceiveException;
import com.aichu.manager.enums.ResultCodeEnum;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MySQLNonTransientException.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(MySQLNonTransientException e, HttpServletResponse response) {
        logger.error("===============>>数据库访问发生异常，异常原因：", e);
        return ApiResult.error(ResultCodeEnum.SYSTEM_ERROR.code(), "数据库访问发生异常!");
    }

    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(MySQLIntegrityConstraintViolationException e, HttpServletResponse response) {
        logger.error("===============>>数据库访问发生异常，异常原因：", e);
        return ApiResult.error(ResultCodeEnum.SYSTEM_ERROR.code(), e.getLocalizedMessage());
    }

    @ExceptionHandler(PersistenceException.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(PersistenceException e, HttpServletResponse response) {
        logger.error("===============>> 执行SQL发生异常，异常原因：", e);
        return ApiResult.error(ResultCodeEnum.SYSTEM_ERROR.code(), "执行SQL发生异常!");
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(BusinessException e, HttpServletResponse response) {
        logger.error("===============>>业务异常，异常原因：", e.getLocalizedMessage());
        return ApiResult.error(e.getCode() == null ? ResultCodeEnum.BUSINESS_ERROR.code() : e.getCode(), e.getMessage());
    }

    @ExceptionHandler(ParamReceiveException.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(ParamReceiveException e, HttpServletResponse response) {
        logger.error("===============>>", e.getLocalizedMessage());
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), e.getLocalizedMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(HttpServletRequest req, HttpMessageNotReadableException e) throws Exception {
        logger.error("===============>>参数错误!", e);
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), "参数转换错误:" + e.getLocalizedMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(HttpServletRequest req, MissingServletRequestParameterException e) throws Exception {
        String msg = "缺少必要参数,参数名称为" + e.getParameterName();
        logger.error("===============>>" + msg, e);
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), msg);
    }

    @ExceptionHandler(value = ServletRequestBindingException.class)
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(HttpServletRequest req, ServletRequestBindingException e) throws Exception {
        logger.error("===============>>参数错误!", e);
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.getMessage());
    }

    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(TypeMismatchException ex) {
        String msg = "参数类型不匹配,参数" + ex.getPropertyName() + "类型应该为" + ex.getRequiredType();
        logger.error("===============>>" + msg, ex);
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), msg);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(HttpServletRequest req, MethodArgumentNotValidException e) throws Exception {
        logger.error("===============>>方法参数接收错误：", e);
        FieldError error = e.getBindingResult().getFieldError();
        String field = error.getField();
        String msg = error.getDefaultMessage();
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), String.format("%s:%s", field, msg));
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(HttpServletRequest req, BindException e) throws Exception {
        logger.error("===============>>方法参数绑定错误：", e);
        FieldError error = e.getBindingResult().getFieldError();
        String field = error.getField();
        String msg = error.getDefaultMessage();
        return ApiResult.error(ResultCodeEnum.PARAM_ERROR.code(), String.format("%s:%s", field, msg));
    }

    @ExceptionHandler(ClientAbortException.class)
    @ResponseBody
    public ApiResult<String> returnExceptionMsg(ClientAbortException ex) {
        logger.error("===============>>Socket ClientAbortException异常");
        return ApiResult.error(ResultCodeEnum.SYSTEM_ERROR.code(), "Socket异常:" + ex.getLocalizedMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(AuthenticationException e, HttpServletResponse response) {
        logger.error("===============>>shiro登录异常：", e.getLocalizedMessage());
        if (e instanceof IncorrectCredentialsException) {
            return ApiResult.error(ResultCodeEnum.USERNAME_OR_PASSWORD_FAILED.code(), ResultCodeEnum.USERNAME_OR_PASSWORD_FAILED.getMessage());
        } else if (e.getCause() instanceof BusinessException) {
            return ApiResult.error(((BusinessException) e.getCause()).getCode(), e.getCause().getMessage());
        }
        return ApiResult.error(ResultCodeEnum.LOGIN_FAILED.code(), ResultCodeEnum.LOGIN_FAILED.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult returnExceptionMsg(Exception e, HttpServletResponse response) {
        logger.error("===============>>系统异常：", e);
        return ApiResult.error(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.getMessage());
    }
}
