package com.yaojiafeng.springboot.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @author yaojiafeng
 * @create 2017-09-11 下午3:32
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.yaojiafeng.springboot.log.LogMDC)")
    public void log() {

    }

    @Around("log()")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            String traceId = TraceUtils.begin();
            MDC.put("mdc_trace_id", traceId);
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable e) {
            throw e;
        } finally {
            MDC.clear();
            TraceUtils.endTrace();
        }
    }


}
