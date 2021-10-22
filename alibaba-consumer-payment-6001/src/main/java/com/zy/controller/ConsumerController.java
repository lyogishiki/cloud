package com.zy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhengyi
 * @Date: 2021/10/18 18:03
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("ping")
    public String ping() {
        return "pong" + serverPort;
    }

}
