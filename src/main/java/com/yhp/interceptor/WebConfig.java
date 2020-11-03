package com.yhp.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//加入LoginInterceptor拦截器
                .addPathPatterns("/admin/**")//匹配需要过滤的路径，admin下所有的页面都会被拦截
                .excludePathPatterns("/admin")//排除登陆页面，避免表单提交失败
                .excludePathPatterns("/admin/login");//排除登录页面，避免登陆页面也被拦截
    }
}
