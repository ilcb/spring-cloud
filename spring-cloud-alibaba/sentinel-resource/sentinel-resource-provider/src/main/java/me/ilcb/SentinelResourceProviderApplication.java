package me.ilcb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelResourceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelResourceProviderApplication.class, args);
        System.out.println("Hello world!");
    }
}