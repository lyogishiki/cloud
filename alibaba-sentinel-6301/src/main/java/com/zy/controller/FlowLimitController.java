package com.zy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.velocity.runtime.Runtime;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @Author: zhengyi
 * @Date: 2021/10/21 18:39
 */
@RestController
@RequestMapping("flowLimit")
public class FlowLimitController {

    @GetMapping("a")
    public String a() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "A";
    }

    @GetMapping("b")
    @SentinelResource(value = "fallback", blockHandler = "blockGetPayment")
    public String b() {
        Random random = new Random();

        if (random.nextInt(5) == 0) {
            throw new RuntimeException();
        }

        return "B";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(required = false, value = "p1") String p1,
                             @RequestParam(required = false, value = "p2") String p2) {
        return "test-hot-key" + p1 + ":" + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "error:" + p1 + ":" + p2 + ":" + exception.getRuleLimitApp();
    }


    public String blockGetPayment(BlockException blockException) {
        blockException.printStackTrace();
        return "进入自定义sentinel BlockHandler方法";
    }
}
