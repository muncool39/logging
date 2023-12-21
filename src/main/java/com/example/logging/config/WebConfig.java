package com.example.logging.config;

import com.example.logging.interceptor.ExecutionTimeInterceptor;
import com.example.logging.interceptor.RequestLoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ExecutionTimeInterceptor())
                .addPathPatterns("/*") // 해당 경로 접근 전 Interceptor 적용
                .excludePathPatterns("/exclude"); // Intercept 제외
    }
}
