package com.dhzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.dhzm.mapper")
public class LyItemServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(LyItemServiceStart.class,args);
    }
}
