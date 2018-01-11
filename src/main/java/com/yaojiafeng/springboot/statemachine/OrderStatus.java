package com.yaojiafeng.springboot.statemachine;

/**
 * @author yaojiafeng
 * @create 2018-01-11 上午11:16
 */
public enum OrderStatus {

    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}