package com.cn.wanxi.front.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
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
       .excludePathPatterns("/user/register")
       .excludePathPatterns("/advertisin/**")
       .excludePathPatterns("/index/**")
       .excludePathPatterns("/imagePic/**")
       .excludePathPatterns("/product/**");
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

    /**
     * 跨域配置
     * @param
     */
    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*"); // 允许任何的head头部
        corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
        corsConfiguration.addAllowedMethod("*"); // 允许任何的请求方法
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    // 添加CorsFilter拦截器，对任意的请求使用
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
