package com.yaojiafeng.springboot.extension.Servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yaojiafeng
 * @create 2017-09-29 下午2:41
 */
@WebListener
public class IndexListener implements ServletContextListener {
    Logger log = LoggerFactory.getLogger(IndexFilter.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("IndexListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
