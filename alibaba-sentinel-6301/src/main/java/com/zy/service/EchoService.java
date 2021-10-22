package com.zy.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @Author: zhengyi
 * @Date: 2021/10/22 16:23
 */
@Service
public class EchoService {

    @SentinelResource(value = "testResource",blockHandler = "handleException")
    public String testResource(){
        return "正常!";
    }

    public String handleException(BlockException ex) {
        return "异常";
    }

}
