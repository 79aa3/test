package com.example.demo.config;

import com.sun.xml.internal.bind.v2.model.impl.BuiltinLeafInfoImpl;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
    //队列 起名:TestDirectQueue
    @Bean
    public Queue TestDirectQueue(){
        //durable:是否持久化 默认false,持久化队列:会被存储在磁盘上,当消息代理重启时仍然存在,暂存队列/:当前连接有效
        //exclusive:默认false,只能被当前创建的连接使用,而且当连接关闭后队列即被删除.优先级高于durable
        //autoDelete:是否自动删除,当没有生产者或者消费之使用此队列,该队列会自动删除
       //一般设置一下队列的持久化就好,其余两个就是默认的false
        return new Queue("TestDirectQueue",true);
    }

    //Direct交换机 起名:TestDirectExchange
    @Bean
    public DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange",true,true);
    }

    //绑定 将队列和交换机绑定,并设置用于匹配件:TestDirectRouting
    @Bean
    public Binding bindingDirect(){
//        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");


    }

    @Bean
    public DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }
}
