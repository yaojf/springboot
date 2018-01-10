package com.yaojiafeng.springboot.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yaojiafeng
 * @create 2018-01-08 下午2:35
 */
@Controller
public class InitBinderController {

    /**
     * 每次ServletInvocableHandlerMethod请求都会调用这个方法注册转化器
     * 也可以注册全局的在{@link org.springframework.web.bind.annotation.ControllerAdvice}
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    @ResponseBody
    public Date date(Date date) {
        return date;
    }

}
