package com.aichu.common.util.exception;

/**
 * 参数错误
 *
 * @author LiangQi.dev@gamil.com
 */
public class ParamReceiveException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer errorCode;//错误编码

    private String message;

    public ParamReceiveException(String message) {
        super(message);
        this.message = message;
    }

    public ParamReceiveException() {
        super("参数错误");
    }

    public ParamReceiveException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public ParamReceiveException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ParamReceiveException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
