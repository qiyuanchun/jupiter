package com.qyc.jupiter.envent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MailEventListener {


    @EventListener(PlaceOrderEvent.class)
    public void handlerEvent(PlaceOrderEvent event){
        System.out.println("发邮件处理event"+event.getOrderNum());
    }
}
