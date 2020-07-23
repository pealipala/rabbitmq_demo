package com.example.demo;

import com.example.demo.config.RabbitFanOutConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads1() {
        rabbitTemplate.convertAndSend("hello","this is a directTest");
    }

    @Test
    void contextLoads2() {
        rabbitTemplate.convertAndSend(RabbitFanOutConfig.FANOUTNAME,null,"this is a fanOut");
    }

}
