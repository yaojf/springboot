package com.yaojiafeng.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yaojiafeng
 * @create 2018-01-03 下午3:52
 */
public interface IExcelController {

    /**
     * 接口方法上的RequestMapping也能被解析到作为HandlerMethod
     *
     * @return
     */
    @GetMapping(value = "/export")
    void export(HttpServletResponse response, HttpServletRequest request);
}
