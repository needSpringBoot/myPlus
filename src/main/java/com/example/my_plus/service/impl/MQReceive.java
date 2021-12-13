package com.example.my_plus.service.impl;


import com.example.my_plus.entity.SysUser;
import com.rabbitmq.client.Channel;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Log4j2
@Component
public class MQReceive {

    @RabbitListener(queues="queue")
    public void processC(SysUser user, Channel channel, @Headers Map<String, Object> heads) {
//        try {
//            int i = 1/0;
//            long deTag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
//            channel.basicAck(deTag, false);
//        } catch (Exception e) {
//            e.getMessage();
//            log.error("设备MQ消息消费异常");
//        }
        System.out.println("queue:Receive:"+user);
    }

    @RabbitListener(queues="queue1")
    public void processC1(String str) {
        System.out.println("queue1:Receive:"+str);
    }

}
