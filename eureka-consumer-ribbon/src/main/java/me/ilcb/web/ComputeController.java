package me.ilcb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/add")
    public String add() {
        return restTemplate.getForObject("http://compute-service/add?numA=10&numB=20", String.class);
    }
}
