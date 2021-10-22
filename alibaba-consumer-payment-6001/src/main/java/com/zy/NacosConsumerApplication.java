package com.zy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhengyi
 * @Date: 2021/10/18 18:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

}
