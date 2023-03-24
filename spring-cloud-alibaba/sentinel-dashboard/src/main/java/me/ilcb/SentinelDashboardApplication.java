package me.ilcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelDashboardApplication.class, args);
        System.out.println("Hello world!");
    }
}