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
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("get/{id}")
    public Payment get(@PathVariable Long id) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readVal
        ObjectMapper objectMapper = new ObjectMapper();
        String result = restTemplate.getForObject("http://127.0.0.1:8001/payment/get/" + id, String.class);
        CommonResult<Payment> r = objectMapper.readValue(result, new PaymentReference());
//        objectMapper.getTypeFactory().constructParametricType(CommonResult.class, Payment.class)
        return r.getData();
    }

}
