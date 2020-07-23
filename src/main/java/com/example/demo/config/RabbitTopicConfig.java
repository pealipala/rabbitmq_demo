package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 22:25
 */
@Configuration
public class RabbitTopicConfig {

    public final static String TOPICNAME = "topic";

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }

    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }

    @Bean
    Queue apple(){
        return new Queue("apple");
    }

    @Bean
    Queue phone(){
        return new Queue("phone");
    }

    @Bean
    Binding xiaomiBind(){
        //表示routeKey以xiaomi开头的会被路由到xiaomi队列上来
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }

    @Bean
    Binding appleBind(){
        //表示routeKey以apple开头的会被路由到apple队列上来
        return BindingBuilder.bind(apple()).to(topicExchange()).with("apple.#");
    }

    @Bean
    Binding phoneBind(){
        //表示routeKey中包含phone的会被路由到phone队列上来
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }

}
