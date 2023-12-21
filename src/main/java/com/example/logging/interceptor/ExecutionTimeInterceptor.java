package com.example.logging.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ExecutionTimeInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private long startTime;

    @Override //handler 메소드 실행 전 호출. execution chain 을 계속 할 지 여부를 return
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override //handler 메소드 실행 후 호출, 뷰 렌더링 전 호출. (ModelAndView 객체 수정 가능)
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("executionTime : {}", executionTime);
    }

    @Override //뷰 렌더링 후 호출. (모든 정리 작업 수행 가능)
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        //
    }
}
