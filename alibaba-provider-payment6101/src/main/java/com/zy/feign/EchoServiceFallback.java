package com.zy.feign;

import org.springframework.stereotype.Component;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 15:40
 */
public class EchoServiceFallback implements EchoService {


    @Override
    public String ping() {
        return "pong fallback";
    }
}
