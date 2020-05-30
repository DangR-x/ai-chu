package com.aichu.common.util.exception;

/**
 * @ClassName BusinessException
 * @Description 全局业务异常处理
 * @Author Melon
 * @Date 2019/7/18 10:03
 * @Version 1.0.0
 **/
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = Integer.MIN_VALUE;
    private Integer code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BusinessException{code=" + this.code + "message=" + this.getMessage() + '}';
    }
}
