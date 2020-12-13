package com.yaojiafeng.springboot.domain;

import lombok.Data;

/**
 * @author yaojiafeng
 * @since 2020/12/13 3:40 下午
 */
@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;
}
