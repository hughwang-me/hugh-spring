package com.hugh.spring.handler;

import com.hugh.spring.common.Result;
import com.hugh.spring.common.ResultCode;
import com.hugh.spring.exception.HughException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> handler(Exception e) {
        if (e instanceof HughException) {
            HughException metaException = (HughException) e;
            log.warn("捕获 [HughException] 错误码 -> {} 错误信息-> {}", metaException.getErrorCode(), metaException.getMessage());
            return Result.error(metaException.getErrorCode(), metaException.getMessage());
        } else {
            log.warn("捕获 [Exception] 错误信息-> {}", e.getMessage());
            return Result.error(ResultCode.PROJECT_EXCEPTION.getCode(), e.getMessage());
        }
    }
}
