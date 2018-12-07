package com.tosim.learn.architecture.disruptor.event;

/**
 * @author yaoyicheng
 * @data 2018/11/14 12:37
 */
public class OrderEvent {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
