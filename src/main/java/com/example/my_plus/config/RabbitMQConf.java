package com.example.my_plus.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConf {
    //http://localhost:15672/
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }
}
