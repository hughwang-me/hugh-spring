package com.hugh.spring.exception;

import com.hugh.spring.common.ResultCode;

public class HughException extends RuntimeException{

    /**
     * 异常错误码
     */
    private Integer errorCode;

    /**
     * 包含错误码和错误信息的构造函数
     * @param errorMessage 异常错误码
     * @param errorCode 异常错误信息
     */
    public HughException(String errorMessage, Integer errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    /**
     * 只传错误信息的构造函数
     * @param errorMessage 异常错误信息
     */
    public HughException(String errorMessage) {
        super(errorMessage);
        this.errorCode = ResultCode.PROJECT_EXCEPTION.getCode();
    }

    /**
     * 根据异常枚举生成异常对象的构造函数
     * @param resultCode 异常枚举值
     */
    public HughException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errorCode = resultCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
