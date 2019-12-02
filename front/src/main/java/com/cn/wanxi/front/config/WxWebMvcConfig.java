package com.cn.wanxi.front.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-22 18:38
 */
@Configuration
public class WxWebMvcConfig implements WebMvcConfigurer {
    /**
     * 用户拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new WxInterceptor())
       .addPathPatterns("/**")
       .excludePathPatterns("/user/login")
       .excludePathPatterns("/user/ssm")
       .excludePathPatterns("/user/register");

    }

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }
    /**
     * 静态资源路径配置
     * @param registry
     */
    @Autowired
    private Environment environment;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/imagePic/**").addResourceLocations("file:"+environment.getProperty("configs.imageurl"));
    }

}
