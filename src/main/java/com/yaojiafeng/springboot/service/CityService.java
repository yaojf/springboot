package com.yaojiafeng.springboot.service;

import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.domain.PageBean;

import java.util.List;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:55.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName
     */
    City findCityByName(String cityName);

    int saveCity(City city);


    /**
     * 你传空list就报错
     *
     * @param list
     * @return
     */
    int creates(List<City> list);

    PageBean<City> list(City city, int pageNum, int pageSize);
}
