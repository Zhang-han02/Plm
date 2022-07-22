package com.plm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 匹配了所有的URL
                .allowedHeaders("*")  // 允许跨域请求包含任意的头信息
                .allowedMethods("*")  // 设置允许的方法
                .allowedOrigins("*")  // 设置允许跨域请求的域名
                .allowCredentials(true);  // 是否允许证书，默认false
    }

}
