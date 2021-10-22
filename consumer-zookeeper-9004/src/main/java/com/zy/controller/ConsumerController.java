package com.zy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2021/9/1 17:29
 */
@RequestMapping("consumer")
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("get")
    public String get() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readVal
        ObjectMapper objectMapper = new ObjectMapper();
        String result = restTemplate.getForObject("http://payment-zookerper/ping", String.class);
//        objectMapper.getTypeFactory().constructParametricType(CommonResult.class, Payment.class)
        return result;
    }

    @GetMapping("discovery")
    public List<String>  discovery() {
        List<String> list = discoveryClient.getServices();

        return list;
    }

    @GetMapping("discovery2")
    public List<ServiceInstance>  discovery2() {
        List<ServiceInstance> instances = discoveryClient.getInstances("payment-zookerper");
//        instances.get(0).getUri().toSt
        return instances;
    }

    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://127.0.0.1:8080/测试/");
        System.out.println(uri.toString());
        System.out.println(uri.toASCIIString());
    }
}
