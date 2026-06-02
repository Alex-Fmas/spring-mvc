package com.atguigu.practice.config;


import com.atguigu.practice.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、容器中需要有这样一个组件：WebMvcConfigurer
 *
 *  注入方式
 *  1）、@Bean
 *  2）、实现WebMvcConfigurer接口
 *
 */

@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer {
    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    /**
     * 添加拦截器
     * InterceptorRegistry : 拦截器注册类
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**");
    }
}
