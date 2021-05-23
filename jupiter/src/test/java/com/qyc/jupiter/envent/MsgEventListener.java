package com.qyc.jupiter.envent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MsgEventListener {

    @EventListener
    public void handlerEvent(PlaceOrderEvent event){
        System.out.println("发短信处理event"+event.getOrderNum());
    }
}
