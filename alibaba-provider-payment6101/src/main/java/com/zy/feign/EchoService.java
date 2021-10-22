package com.zy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 15:35
 */
@FeignClient(name = "nacos-payment-consumer",
        fallback = EchoServiceFallback.class,
        path = "consumer"
)
public interface EchoService {

    /**
     * sss
     * @return
     */
    @GetMapping("ping")
    String ping();

//    @GetMapping("/echo/{str}")
//    String echo(@PathVariable("str") String str);
//
//    @GetMapping("/divide")
//    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
//
//    default String divide(Integer a) {
//        return divide(a, 0);
//    }
//
//    @GetMapping("/notFound")
//    String notFound();


}
