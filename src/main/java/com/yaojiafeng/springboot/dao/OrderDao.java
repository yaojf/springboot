package com.yaojiafeng.springboot.dao;

import com.yaojiafeng.springboot.domain.Order;

import java.util.List;

/**
 * @author yaojiafeng
 * @create 2018-01-11 上午11:19
 */
public interface OrderDao {

    Order findByOrderId(Integer orderId);

    int save(Order order);

    List<Order> findAll();
}
