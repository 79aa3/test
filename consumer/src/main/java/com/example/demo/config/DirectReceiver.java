package com.example.demo.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称
public class DirectReceiver {
    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("DirectReceiver消费者收到的信息:"+testMessage.toString());
    }
}
