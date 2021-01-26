package com.wuzx.config;

import com.wuzx.security.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String API_PATTERN = "/API/**";



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加登录、权限拦截器，并排除登录接口
        System.out.println("addInterceptors");
        registry.addInterceptor(loginInterceptor()).addPathPatterns(API_PATTERN).excludePathPatterns("/API/login");
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        System.out.println("loginInterceptor");
        return new LoginInterceptor();}
}
