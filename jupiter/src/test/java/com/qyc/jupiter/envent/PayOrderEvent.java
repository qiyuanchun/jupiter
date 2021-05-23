package com.qyc.jupiter.envent;

import org.springframework.context.ApplicationEvent;


public class PayOrderEvent extends ApplicationEvent {

    private String orderNum;


    public PayOrderEvent(Object source) {
        super(source);
    }

    public PayOrderEvent(Object source, String orderNum) {
        super(source);
        orderNum = orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }
}
