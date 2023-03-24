package me.ilcb.sentinel.consumer.reveal;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;

public class BuyBlockHandler {
    // sentinel回退
    public static String buyBlock(@PathVariable String name, @PathVariable Integer count, BlockException e) {
        return String.format("【进入blockHandler方法】购买%d份%s失败，当前购买人数过多，请稍后再试", count, name);
    }
}
