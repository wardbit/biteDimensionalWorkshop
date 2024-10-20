package com.example.luntan2.config;

import com.example.luntan2.interceptor.loginInterceptor;
import io.swagger.annotations.Api;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Api("拦截器注册")
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new loginInterceptor()).addPathPatterns("/logup/**");
    }
}
