package com.yaojiafeng.springboot.domain;

import com.yaojiafeng.springboot.statemachine.OrderStatus;

/**
 * @author yaojiafeng
 * @create 2018-01-11 上午11:17
 */
public class Order {

    private Integer id;

    private Integer orderId;

    private OrderStatus status;

    public Order() {
    }

    public Order(Integer orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status=" + status +
                '}';
    }
}
