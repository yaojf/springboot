package com.yaojiafeng.springboot.statemachine;

/**
 * @author yaojiafeng
 * @create 2018-01-11 上午11:16
 */
public enum OrderStatusChangeEvent {

    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED
}
