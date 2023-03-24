package me.ilcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"me.ilcb"})
public class ZuulProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulProviderApplication.class, args);
    }
}
