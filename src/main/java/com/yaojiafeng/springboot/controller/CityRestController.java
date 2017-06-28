package com.yaojiafeng.springboot.controller;


import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


    @RequestMapping(value = "/api/city",method = RequestMethod.POST)
    public int saveCity(@Valid @RequestBody City city){
        return cityService.saveCity(city);
    }
}