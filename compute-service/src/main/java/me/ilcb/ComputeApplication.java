package me.ilcb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputeApplication.class).web(true).run(args);
    }
}
