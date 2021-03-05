package com.github.sb.web.exp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description: handler处理前异常处理
 * @author: yanghao
 * @createDate: 2021/3/6
 * @since: 1.0
 */
@Slf4j
@Component
@WebFilter(urlPatterns = "/*", filterName = "preHandleExceptionFilter")
public class PreHandlerExceptionFilter implements Filter {

    @Resource
    private SbExceptionHandler sbExceptionHandler;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("{}", filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("23333");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            sbExceptionHandler.handle(e);
        }

    }

    @Override
    public void destroy() {

    }

}