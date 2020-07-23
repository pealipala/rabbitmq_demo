package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 20:51
 */
//direct方式
@Configuration
public class RabbitDirectConfig {

    public final static String DIRECTNAME = "pealipala";

    @Bean
    Queue queue(){
        return new Queue("hello");
    }

    @Bean
    DirectExchange directExchange(){
        //持久 true 自动删除 false
        return new DirectExchange(DIRECTNAME,true,false);
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
