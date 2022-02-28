package com.dhzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LyRegistryStart {
    public static void main(String[] args) {
        SpringApplication.run(LyRegistryStart.class,args);
    }
}
