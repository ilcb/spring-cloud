package me.ilcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RibbonServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonServerApplication.class, args);
        System.out.println("Hello world!");
    }
}