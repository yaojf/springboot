package com.yaojiafeng.springboot.statemachine;

import com.yaojiafeng.springboot.dao.OrderDao;
import com.yaojiafeng.springboot.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author yaojiafeng
 * @create 2018-01-11 下午2:16
 */
@Component
public class OrderStateService {

    private PersistStateMachineHandler handler;


    public OrderStateService(PersistStateMachineHandler handler) {
        this.handler = handler;
    }

    @Autowired
    private OrderDao orderDao;


    public String listDbEntries() {
        List<Order> orders = orderDao.findAll();
        StringJoiner sj = new StringJoiner(",");
        for (Order order : orders) {
            sj.add(order.toString());
        }
        return sj.toString();
    }


    public boolean change(int orderId, OrderStatusChangeEvent event) {
        Order o = orderDao.findByOrderId(orderId);
        return handler.handleEventWithState(MessageBuilder.withPayload(event).setHeader("order", orderId).build(), o.getStatus());
    }

}
