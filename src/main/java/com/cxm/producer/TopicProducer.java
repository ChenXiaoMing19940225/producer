package com.cxm.producer;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
public class TopicProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

     public void sendMessage(String message){
        ActiveMQTopic destination = new ActiveMQTopic("activemqTopic");
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
