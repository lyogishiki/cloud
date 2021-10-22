package com.zy.controller;

import com.zy.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 16:57
 */
@RestController
@RequestMapping("config2")
public class ConfigController2 {
    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int age;

    @Autowired
    private UserConfig userConfig;

    @RequestMapping("ping")
    public String ping() {
        return userName + ":" + age;
    }

    @RequestMapping("ping2")
    public String ping2() {
        return userConfig.getId() + ":" + userConfig.getName() + ":" + userConfig.getAge();
    }
}
