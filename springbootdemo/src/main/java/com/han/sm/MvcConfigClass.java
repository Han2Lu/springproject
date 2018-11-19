package com.han.sm;

import com.han.sm.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * className:MvcConfigClass
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-10 16:44
 */
@SpringBootConfiguration  //标识该类为配置类
public class MvcConfigClass implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/emp/toLogin","/emp/login");
    }


}
