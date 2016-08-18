/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.springboot.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/8/16 下午3:36 $
 */
@Controller
public class HelloController {

    @Value("${com.didispace.blog.name}")
    private String name;
    @Value("${com.didispace.blog.title}")
    private String title;


    @ApiOperation(value = "hello world", notes = "")
    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
        System.out.println(name);
        System.out.println(title);

        return "Hello World";
    }

    @RequestMapping("/world")
    public String world(ModelMap modelMap) {
        modelMap.put("msg", "hello world");
        return "hello";
    }

}
