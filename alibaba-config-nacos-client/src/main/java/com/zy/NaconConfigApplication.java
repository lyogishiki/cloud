package com.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 16:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NaconConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NaconConfigApplication.class, args);
    }

}
