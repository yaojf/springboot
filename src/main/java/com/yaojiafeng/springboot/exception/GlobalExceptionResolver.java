package com.yaojiafeng.springboot.exception;

import com.yaojiafeng.springboot.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yaojiafeng
 * @create 2017-07-26 下午2:15
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionResolver {


    /**
     * 没有设置异常的类型，读取方法参数类型，作为匹配的异常
     * @param throwable
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Result exp(Throwable throwable) {
        return new Result(-1, throwable.getMessage());
    }

}
