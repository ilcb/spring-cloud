package me.ilcb.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("compute-service")
public interface IComputeClient {
    @GetMapping("/add")
    Integer add(@RequestParam(value = "numA") Integer numA, @RequestParam(value = "numB") Integer numB);
}
