package me.ilcb.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BusRegisterServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusRegisterServerApplication.class, args);
        System.out.println("Hello world!");
    }
}