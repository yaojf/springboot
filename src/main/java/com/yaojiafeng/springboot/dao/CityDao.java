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

    /**
     * insert语句keyProperty="id" useGeneratedKeys="true"
     * 如果传了id就返回的生成key值就是传的id值
     * @param city
     * @return
     */
    int saveCity(City city);

    /**
     * mybatis会根据具体传入对象的字段的类型，生成对应的ParameterMapping，故写sql的时候，不需要指定Java类型
     * 同理写resultMap的result映射的时候也不需要指定具体的Java类型
     * mybatis会根据对象的class解析字段类型
     *
     * @param list
     * @return
     */
    int creates(List<City> list);


    /**
     * mybatis参数类型声明，并无实质校验作用，传map和传obj都可以
     * @param city
     * @return
     */
    List<City> list(City city);
}
