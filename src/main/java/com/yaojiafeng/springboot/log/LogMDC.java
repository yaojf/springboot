package com.yaojiafeng.springboot.log;

import java.lang.annotation.*;

/**
 * @author yaojiafeng
 * @create 2017-09-11 下午3:33
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogMDC {

}
