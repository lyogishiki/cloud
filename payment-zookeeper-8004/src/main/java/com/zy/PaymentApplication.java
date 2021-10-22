package com.zy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: zhengyi
 * @Date: 2021/8/31 14:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Value("${server.port}")
    private String port;


    @RequestMapping("ping")
    public String pong() {
        return "pong:" + port + UUID.randomUUID();
    }
}
