package com.tosim.learn.architecture.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.tosim.learn.architecture.disruptor.event.OrderEvent;

/**
 * @author yaoyicheng
 * @data 2018/11/14 12:39
 */
public class OrderEventFactory implements EventFactory<OrderEvent> {

    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}
