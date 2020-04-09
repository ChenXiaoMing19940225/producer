package com.cxm.producer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TopicCustomer {
    @JmsListener(destination = "activemqTopic")
    public void subscrible(String msg){
        System.out.println(new Date() +"消费者A消费一条消息"+msg);
    }
    @JmsListener(destination = "activemqTopic")
    public void subscrible1(String msg){
        System.out.println(new Date() +"消费者B消费一条消息"+msg);
    }
}

