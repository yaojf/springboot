package com.yaojiafeng.springboot.extension.ConfigurationProperties;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author yaojiafeng
 * @create 2017-09-29 下午5:12
 */
@Data
@ConfigurationProperties(prefix = MQClientConfig.prefix)
@ConditionalOnMissingBean({MQClientConfig.class})
public class MQClientConfig {
    public static final String prefix = "mqClientConfig";
    
    private Map<String, MQServerConf> mqConfigs;
}
