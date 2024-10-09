package com.example.luntan2.config;

import com.example.luntan2.interceptor.loginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class webConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new loginInterceptor()).addPathPatterns("/user/**");
    }
}
