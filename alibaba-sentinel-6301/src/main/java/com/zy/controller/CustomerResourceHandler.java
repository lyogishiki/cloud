package com.zy.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengyi
 * @Date: 2021/10/22 16:45
 */
public class CustomerResourceHandler {


    public static String handleException(BlockException blockException) {
        System.out.println("Jinrufangfa");
        return "进入自定义sentinel BlockHandler方法---1";
    }

    public static String handleException2(BlockException blockException) {
        return "进入自定义sentinel BlockHandler方法---2";
    }

}
