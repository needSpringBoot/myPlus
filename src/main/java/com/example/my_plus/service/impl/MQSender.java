package com.example.my_plus.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQSender {

    @Autowired
    private AmqpTemplate template;

    public void send(String msg) {
        template.convertAndSend("queue",msg);
    }

    public void send(Object msg) {
        template.convertAndSend("queue",msg);
    }

    public void send1(String msg) {
        template.convertAndSend("queue1",msg);
    }

}
