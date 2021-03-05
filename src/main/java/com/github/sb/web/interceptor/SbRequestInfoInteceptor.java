package com.github.sb.web.interceptor;

import com.github.sb.web.model.SbRequestInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SbRequestInfoInteceptor implements HandlerInterceptor {

    private static final ThreadLocal<SbRequestInfo> requestInfoTh = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestInfoTh.set(composeRequestInfo(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SbRequestInfo requestInfo = requestInfoTh.get();
        long cost = System.currentTimeMillis() - requestInfo.getStartTime();
        log.info("{}, cost {} ms", requestInfo, cost);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        requestInfoTh.remove();
    }

    private SbRequestInfo composeRequestInfo(HttpServletRequest request) {
        return SbRequestInfo.builder()
                .clientIp(request.getRemoteAddr())
                .method(request.getMethod())
                .uri(request.getRequestURI())
                .contentType(request.getContentType())
                .startTime(System.currentTimeMillis())
                .build();
    }

}
