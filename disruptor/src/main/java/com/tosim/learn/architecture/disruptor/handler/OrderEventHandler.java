package com.tosim.learn.architecture.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.tosim.learn.architecture.disruptor.event.OrderEvent;

/**
 * @author yaoyicheng
 * @data 2018/11/14 12:41
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent orderEvent, long l, boolean b) throws Exception {
        System.out.println("消费者：" + orderEvent.getValue());
    }
}
