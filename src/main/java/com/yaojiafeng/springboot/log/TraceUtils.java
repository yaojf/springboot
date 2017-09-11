package com.yaojiafeng.springboot.log;

import java.util.UUID;

/**
 * @author yaojiafeng
 * @create 2017-09-11 下午3:39
 */
public class TraceUtils {

    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static String begin() {
        inheritableThreadLocal.set(UUID.randomUUID().toString());
        return inheritableThreadLocal.get();
    }

    public static void endTrace() {
        inheritableThreadLocal.remove();
    }
}
