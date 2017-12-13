package com.yaojiafeng.springboot.controller;


import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.domain.PageBean;
import com.yaojiafeng.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:54.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }


    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public int saveCity(@Valid @RequestBody City city) {
        return cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/citys", method = RequestMethod.GET)
    public PageBean<City> findOneCity(City city,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        return cityService.list(city, pageNum, pageSize);
    }

}