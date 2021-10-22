package com.zy.controller;

import com.zy.feign.EchoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 14:34
 */
@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    @Qualifier("sentinelRestTemplate")
    private RestTemplate sentinelRestTemplate;

    @Autowired
    private EchoService echoService;

    /**
     * 加了LoadBalanced的restTemplate只能被用于负载均衡了情况了.写死IP都会提示没有实例..
     *
     * @return
     */
    @GetMapping("ping")
    public String ping() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-payment-consumer");
        String url = String.format("http://%s:%s/consumer/ping", serviceInstance.getHost(), serviceInstance.getPort());
        System.out.println("request url:" + url);
        String res = restTemplate.getForObject(url, String.class);
        return res;
    }

    @GetMapping("sentinelPing")
    public String sentinelPing() {
        return sentinelRestTemplate.getForObject("http://nacos-payment-consumer/consumer/ping", String.class);
    }

    @GetMapping("feignMapping")
    public String feignMapping() {
        return echoService.ping();
    }

    @GetMapping("ping2")
    public String ping2() {
        String res = restTemplate.getForObject("http://nacos-payment-consumer/consumer/ping", String.class);
        return res;
    }

    @GetMapping("test")
    public List<String> test() {
        return discoveryClient.getServices();
    }


    @GetMapping("test2")
    public ServiceInstance test2() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-payment-consumer");
        return serviceInstance;
    }

}
