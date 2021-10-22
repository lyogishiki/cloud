package com.zy.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zhengyi
 * @Date: 2021/10/19 17:20
 */
@ConfigurationProperties(prefix = "user")
//@PropertySource("nacos-config-client.yaml")
@Configuration
@Data
public class UserConfig {

    private Integer id;
    private Integer age;
    private String name;

}
