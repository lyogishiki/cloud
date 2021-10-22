package com.zy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 17:58
 */
@ConfigurationProperties(prefix = "ext2")
//@PropertySource("ext2.properties")
@Configuration
@Data
public class Ext2Config {

    private String id;

}
