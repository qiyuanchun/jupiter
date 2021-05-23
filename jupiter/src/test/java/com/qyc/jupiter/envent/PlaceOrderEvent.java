package com.qyc.jupiter.envent;

import org.springframework.context.ApplicationEvent;


public class PlaceOrderEvent extends ApplicationEvent {

    private String orderNum;


    public PlaceOrderEvent(Object source) {
        super(source);
    }

    public PlaceOrderEvent(Object source,String orderNum) {
        super(source);
        orderNum = orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }
}
