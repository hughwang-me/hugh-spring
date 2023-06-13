package com.hugh.spring.aop;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.hugh.spring.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    public void controllerPointCut() {
    }

    @Around("controllerPointCut()")
    public Object aroundHandler(ProceedingJoinPoint point) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Object resultEntity;
        try {
            log.info("执行开始: " + point.getSignature() + " 参数：" + Lists.newArrayList(point.getArgs()).toString());
            resultEntity = point.proceed(point.getArgs());
            log.info("执行结束: " + point.getSignature() + "， 返回值：" + resultEntity.toString());
            log.info("耗时：" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS) + "(毫秒).");
            return resultEntity;
        } catch (Throwable var5) {
            stopwatch.stop();
            resultEntity = this.handlerException(point, var5);
            return resultEntity;
        }
    }

    private Object handlerException(ProceedingJoinPoint pjp, Throwable e) throws Throwable {
        Result<?> resultEntity = null;
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Class returnType = signature.getReturnType();
        if (ResponseEntity.class.equals(returnType)) {
            log.error("方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + "，异常：" + e.getMessage(), e);
            return null;
        } else if (Void.TYPE.equals(returnType)) {
            log.error("方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + "，异常：" + e.getMessage(), e);
            return null;
        } else if (String.class.equals(returnType)) {
            log.error("方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + "，异常：" + e.getMessage(), e);
            return null;
        } else {
            if (e instanceof RuntimeException) {
                log.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
//                resultEntity = Result.error(e.getMessage());
                throw e;
            } else {
                log.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
                resultEntity = Result.error(e.getMessage());
            }

            return resultEntity;
        }
    }
}
