package com.yaojiafeng.springboot.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author yaojiafeng
 * @create 2017-12-13 下午4:18
 */
@Configuration
public class MybatisInterceptorConfig {

    @Bean
    public Interceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(new Properties());
        return pageInterceptor;
    }
}
