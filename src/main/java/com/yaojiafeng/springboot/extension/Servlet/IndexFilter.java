package com.yaojiafeng.springboot.extension.Servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yaojiafeng
 * @create 2017-09-29 下午2:39
 */
@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class IndexFilter implements Filter {
    Logger log = LoggerFactory.getLogger(IndexFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init IndexFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter IndexFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}