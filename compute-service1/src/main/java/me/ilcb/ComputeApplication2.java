package me.ilcb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeApplication2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputeApplication2.class).web(true).run(args);
    }
}
