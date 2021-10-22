package com.zy.controller;

import com.zy.config.Ext1Config;
import com.zy.config.Ext2Config;
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
@RequestMapping("config")
@RefreshScope
public class ConfigController {
    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int age;

    @Value("${share0.name}")
    private String share0Name;

    @Value("${share1.name}")
    private String share1Name;

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private Ext1Config ext1Config;

    @Autowired
    private Ext2Config ext2Config;

    @RequestMapping("ping")
    public String ping() {
        return userName + ":" + age;
    }

    @RequestMapping("ping2")
    public String ping2() {
        return userConfig.getId() + ":" + userConfig.getName() + ":" + userConfig.getAge();
    }

    @RequestMapping("ping3")
    public String ping3() {
        return ext1Config.getId();
    }

    @RequestMapping("ping4")
    public String ping4() {
        return ext2Config.getId();
    }

    @RequestMapping("ping5")
    public String ping5() {
        return share0Name + ":" + share1Name;
    }
}
