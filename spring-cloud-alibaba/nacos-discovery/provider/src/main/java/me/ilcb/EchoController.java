package me.ilcb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/{string}")
    public String echo(@PathVariable(value = "string")String args) {
        return "echo: " + args + ", port: " + serverPort;
    }
}
