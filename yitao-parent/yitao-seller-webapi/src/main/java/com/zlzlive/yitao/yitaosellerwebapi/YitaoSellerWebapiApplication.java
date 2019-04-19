package com.zlzlive.yitao.yitaosellerwebapi;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.zlzlive.yitao")
public class YitaoSellerWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YitaoSellerWebapiApplication.class, args);
    }

}
