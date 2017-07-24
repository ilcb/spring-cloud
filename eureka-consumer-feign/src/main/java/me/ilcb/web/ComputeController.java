package me.ilcb.web;

import me.ilcb.service.IComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {
    @Autowired
    private IComputeClient client;

    @GetMapping("/consume")
    public Integer add() {
        return client.add(10, 20);
    }
}
