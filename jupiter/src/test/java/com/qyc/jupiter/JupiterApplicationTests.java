package com.qyc.jupiter;

import com.qyc.jupiter.envent.PlaceOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JupiterApplication.class)
class JupiterApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @DisplayName("事件监听测试")
    @Test
    public void eventTest(){
        PlaceOrderEvent event = new PlaceOrderEvent(this, "1199");
//        PayOrderEvent event = new PayOrderEvent(this, "1199");
        applicationContext.publishEvent(event);
    }


}
