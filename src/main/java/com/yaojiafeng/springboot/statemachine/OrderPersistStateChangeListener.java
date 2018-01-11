package com.yaojiafeng.springboot.statemachine;

import com.yaojiafeng.springboot.dao.OrderDao;
import com.yaojiafeng.springboot.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

/**
 * @author yaojiafeng
 * @create 2018-01-11 下午2:12
 */
public class OrderPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {


    @Autowired
    private OrderDao orderDao;


    @Override
    public void onPersist(State<OrderStatus, OrderStatusChangeEvent> state, Message<OrderStatusChangeEvent> message,
                          Transition<OrderStatus, OrderStatusChangeEvent> transition, StateMachine<OrderStatus, OrderStatusChangeEvent> stateMachine) {
        if (message != null && message.getHeaders().containsKey("order")) {
            Integer order = message.getHeaders().get("order", Integer.class);
            Order o = orderDao.findByOrderId(order);
            OrderStatus status = state.getId();
            o.setStatus(status);
            orderDao.save(o);
        }
    }
}
