package com.wxc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wangxiaocheng
 * @title: Application
 * @projectName base-provider
 * @description: TODO
 * @date 2021/7/16 9:45
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.wxc.mapper")
@Async
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
