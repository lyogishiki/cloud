package com.zy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhengyi
 * @Date: 2021/10/22 16:05
 */
@RestController
public class RateLimitController {

    @GetMapping("/rate1")
    @SentinelResource(value = "rate1",blockHandlerClass = CustomerResourceHandler.class,blockHandler = "handleException")
    public String rate1() {
        return "rate1";
    }


    @GetMapping("/rate2")
    @SentinelResource(value = "rate2",blockHandlerClass = CustomerResourceHandler.class,blockHandler = "handleException2")
    public String rate2() {
        return "rate2";
    }

}
