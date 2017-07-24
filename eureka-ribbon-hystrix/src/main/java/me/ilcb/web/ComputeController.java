package me.ilcb.web;

import me.ilcb.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {
    @Autowired
    private ComputeService computeService;

    @GetMapping("/add")
    public String add() {
        return computeService.addService();
    }
}
