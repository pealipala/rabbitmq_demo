package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 22:44
 */
@Configuration
public class RabbitHeaderConfig {

    public final static String HEADERNAME = "header";

    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange(HEADERNAME,true,false);
    }

    @Bean
    Queue queueName(){
        return new Queue("queue-name");
    }

    @Bean
    Queue queueAge(){
        return new Queue("queue-age");
    }

    @Bean
    Binding bindName(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","pealipala");
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding bindAge(){
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();
    }
}
