package me.ilcb.sentinel.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import me.ilcb.sentinel.consumer.reveal.BuyBlockHandler;
import me.ilcb.sentinel.consumer.reveal.BuyFallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BuyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("buy/{name}/{count}")
    @SentinelResource(value = "buy",
            fallback = "buyFallback",
            fallbackClass = BuyFallBack.class,
            blockHandler = "buyBlock",
            blockHandlerClass = BuyBlockHandler.class,
            exceptionsToIgnore = NullPointerException.class)
    public String buy(@PathVariable String name, @PathVariable Integer count) {
        if (count >= 20) {
            throw new IllegalArgumentException("购买数量过多");
        }
        if ("miband".equalsIgnoreCase(name)) {
            throw new NullPointerException("已售罄");
        }
        Map<String, Object> params = new HashMap<>(2);
        params.put("name", name);
        params.put("count", count);
        return this.restTemplate.getForEntity("http://sentinel-resource-provider/goods/buy/{name}/{count}", String.class, params).getBody();
    }



}
