/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.springboot;

import com.yaojiafeng.springboot.dao.CityDao;
import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.service.CityService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/8/16 下午3:08 $
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.yaojiafeng.springboot.dao")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);


//        CityService cityService = context.getBean(CityService.class);
//        List<City> list = new ArrayList<>();
//        City city = new City();
//        city.setId(3L);
//        city.setCityName("1");
//        city.setProvinceId(1L);
//        city.setDescription("nima");
//        City city2 = new City();
//        city2.setId(4L);
//        city2.setCityName("1");
//        city2.setProvinceId(1L);
//        city2.setDescription("nima");
//        list.add(city);
//        list.add(city2);
//        cityService.creates(list);
        

//        CityDao cityDao = context.getBean(CityDao.class);
//        City city = new City();
//        city.setId(101L);
//        List<City> list = cityDao.list(city);
//        System.out.println(list);



    }

}