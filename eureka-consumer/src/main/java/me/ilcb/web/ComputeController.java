package me.ilcb.web;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {
    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate template;

    @GetMapping("/add")
    public String add() {
        ServiceInstance instance = client.choose("compute-service");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/add?numA=10&numB=20";
        System.out.println(url);
        return template.getForObject(url, String.class);
    }
}
