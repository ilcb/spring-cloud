package me.ilcb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("check")
    private String check() {
        log.info("health check");
        return "ok";
    }

    @GetMapping("hello")
    public String hello() {
        log.info("hello");
        return "hello from server provider";
    }
}
