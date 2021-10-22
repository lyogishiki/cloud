package com.zy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhengyi
 * @Date: 2021/9/1 17:27
 */
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper(RestTemplate restTemplate) {
        ObjectMapper mapper = new ObjectMapper();

        for(ClientHttpRequestInterceptor interceptor : restTemplate.getInterceptors()) {
            System.out.println(interceptor);
        }

        return mapper;
    }

}
