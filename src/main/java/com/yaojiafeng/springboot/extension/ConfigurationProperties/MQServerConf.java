package com.yaojiafeng.springboot.extension.ConfigurationProperties;

import lombok.Data;

/**
 * @author yaojiafeng
 * @create 2017-09-29 下午5:13
 */
@Data
public class MQServerConf {
    private String topic;
    private String producerGroup;
    private String consumerGroup;
    private Boolean useOns;
    private String accessKey;
    private String secretKey;
    private Integer timeout = 3000;
    private String namesrvAddr;
    private Integer messageSize = 4 * 1024 * 1024;
    private String consumerModel = "CLUSTERING";
}
