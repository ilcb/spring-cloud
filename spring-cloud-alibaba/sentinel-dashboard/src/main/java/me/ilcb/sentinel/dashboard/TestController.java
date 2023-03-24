package me.ilcb.sentinel.dashboard;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("test1")
    public String test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "test1";
    }

    @GetMapping("test2")
    public String test2() {
        return "test2 " + helloService.hello();
    }

    @GetMapping("buy")
    @SentinelResource(value = "buy")
    public String buy(String goodName, Integer count) {
        return "买" + count + "份" + goodName;
    }
}
