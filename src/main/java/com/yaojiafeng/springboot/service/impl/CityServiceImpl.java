package com.yaojiafeng.springboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaojiafeng.springboot.dao.CityDao;
import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.domain.PageBean;
import com.yaojiafeng.springboot.log.LogMDC;
import com.yaojiafeng.springboot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:56.
 */
@Service
@Slf4j
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @LogMDC
    public City findCityByName(String cityName) {
        log.info("start invoke findCityByName");
        City city = cityDao.findByName(cityName);
        log.info("end invoke findCityByName");
        return city;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public int creates(List<City> list) {
        return cityDao.creates(list);
    }

    @Override
    public PageBean<City> list(City city, int pageNum, int pageSize) {
        //分页处理
        PageHelper.startPage(pageNum, pageSize);
        //查询
        List<City> cityList = cityDao.list(city);
        //清空
        PageHelper.clearPage();
        //获取分页信息
        return new PageBean<>(cityList);
    }

}
