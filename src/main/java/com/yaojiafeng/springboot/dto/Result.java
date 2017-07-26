package com.yaojiafeng.springboot.dto;

import lombok.Data;

/**
 * @author yaojiafeng
 * @create 2017-07-26 下午2:39
 */
@Data
public class Result {
    private int code;
    private String message;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
