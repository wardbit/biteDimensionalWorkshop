package com.example.luntan2.config;

import com.example.luntan2.interceptor.loginInterceptor;
//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Tag(name="拦截器注册")
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new loginInterceptor()).addPathPatterns("/logup/**");
    }
}
