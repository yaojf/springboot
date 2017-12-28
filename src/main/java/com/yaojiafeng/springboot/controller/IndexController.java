package com.yaojiafeng.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaojiafeng
 * @create 2017-12-28 下午2:08
 */
@RestController
public class IndexController {

    /**
     * ResponseStatus注解会在构造ServletInvocableHandlerMethod时解析到，
     * 并且在调用完设置状态码到HttpServletResponse里
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String index() {
        return "ok";
    }

}
