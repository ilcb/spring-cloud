package me.ilcb.eureka.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController {
    private final Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    private DiscoveryClient client;

    @GetMapping("/info")
    public String info() {
        @SuppressWarnings("deprecation")
        List<String> serviceList = client.getServices();
        List<ServiceInstance> list = client.getInstances("eureka-provider-8001]");
        if (!CollectionUtils.isEmpty(list)) {
            log.info("list: {}", list);
        }
        log.info(serviceList.toString());
        return serviceList.toString();
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
