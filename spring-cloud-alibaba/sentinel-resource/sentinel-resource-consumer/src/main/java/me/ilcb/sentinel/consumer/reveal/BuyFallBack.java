package me.ilcb.sentinel.consumer.reveal;

import org.springframework.web.bind.annotation.PathVariable;

public class BuyFallBack {

    // 异常回退
    public static String buyFallback(@PathVariable String name, @PathVariable Integer count, Throwable throwable) {
        return String.format("【进入fallback方法】购买%d份%s失败，%s", count, name, throwable.getMessage());
    }
}
