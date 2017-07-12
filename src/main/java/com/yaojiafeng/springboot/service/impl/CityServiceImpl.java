package com.yaojiafeng.springboot.service.impl;

import com.yaojiafeng.springboot.dao.CityDao;
import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:56.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public int saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public int creates(List<City> list) {
        return cityDao.creates(list);
    }

}
