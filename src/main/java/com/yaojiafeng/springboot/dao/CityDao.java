package com.yaojiafeng.springboot.dao;

import com.yaojiafeng.springboot.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    int saveCity(City city);

    /**
     * mybatis会根据具体传入对象的字段的类型，生成对应的ParameterMapping，故写sql的时候，不需要指定Java类型
     * 同理写resultMap的result映射的时候也不需要指定具体的Java类型
     * mybatis会根据对象的class解析字段类型
     * @param list
     * @return
     */
    int creates(List<City> list);
}
