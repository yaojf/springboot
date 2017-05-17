package com.yaojiafeng.springboot.dao;

import com.yaojiafeng.springboot.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:50.
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
