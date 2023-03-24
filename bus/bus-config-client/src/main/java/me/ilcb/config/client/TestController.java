package me.ilcb.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${config.version}")
    private String version;

    @GetMapping("/message")
    public String getMessage() {
        return "info: " + configInfo + ", version: " + version;
    }
}
