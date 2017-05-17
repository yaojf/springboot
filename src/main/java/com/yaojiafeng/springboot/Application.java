/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/8/16 下午3:08 $
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.yaojiafeng.springboot.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}