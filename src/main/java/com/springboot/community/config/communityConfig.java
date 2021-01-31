package com.springboot.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author zhouwenxiao
 * @create 2020-12-31 18:44
 */
@Configuration
public class communityConfig {
    /*
    返回的对象将会被装配进入测试类中
     */
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
