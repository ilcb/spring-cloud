package me.ilcb.sentinel.dashboard;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @SentinelResource("hello")
    public String hello() {
        return "hello";
    }
}
