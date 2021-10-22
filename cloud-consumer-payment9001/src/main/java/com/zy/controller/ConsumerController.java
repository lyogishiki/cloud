package com.zy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zy.entity.CommonResult;
import com.zy.entity.Payment;
import com.zy.entity.PaymentReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

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

    @GetMapping("get/{id}")
    public Payment get(@PathVariable Long id) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readVal
        ObjectMapper objectMapper = new ObjectMapper();
        String result = restTemplate.getForObject("http://cloud-payment-service/payment/get/" + id, String.class);
        CommonResult<Payment> r = objectMapper.readValue(result, new PaymentReference());
//        objectMapper.getTypeFactory().constructParametricType(CommonResult.class, Payment.class)
        return r.getData();
    }

    @GetMapping("discovery")
    public List<String>  discovery() {
        List<String> list = discoveryClient.getServices();

        return list;
    }

    @GetMapping("discovery2")
    public List<ServiceInstance>  discovery2() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
//        instances.get(0).getUri().toSt
        return instances;
    }

    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://127.0.0.1:8080/测试/");
        System.out.println(uri.toString());
        System.out.println(uri.toASCIIString());
    }
}
