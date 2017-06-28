package com.yaojiafeng.springboot.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:50.
 */
@Data
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    @NotBlank(message = "城市名称不能为空")
    private String cityName;

    /**
     * 描述
     */
    private String description;

}
