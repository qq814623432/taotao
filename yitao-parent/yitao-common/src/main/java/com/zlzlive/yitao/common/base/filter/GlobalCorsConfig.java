package com.zlzlive.yitao.common.base.filter;

import lombok.val;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootConfiguration
public class GlobalCorsConfig {
    @Bean
    public  CorsFilter CorsFilter(){
        CorsConfiguration config = new CorsConfiguration();
        //配置允许跨域的域名
        config.addAllowedOrigin("http://api.yitao.com");
        config.addAllowedOrigin("http://manage.yitao.com");
        config.addAllowedOrigin("http://image.yitao.com");
        //允许发送cookie
        config.setAllowCredentials(true);
        // 允许跨域接口
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setMaxAge(3600L);
        // 允许头信息
        config.addAllowedHeader("*");
        // 添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }
}
