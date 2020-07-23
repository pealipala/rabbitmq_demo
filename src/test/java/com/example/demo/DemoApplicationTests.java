package com.example.demo;

import com.example.demo.config.RabbitFanOutConfig;
import com.example.demo.config.RabbitHeaderConfig;
import com.example.demo.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
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

    @Test
    void contextLoads3() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"apple.XXX","this is a topic about apple");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.XXX","this is a topic about xiaomi");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"phone","this is a topic about phone");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"apple.phone","this is a topic about applephone");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.phone","this is a topic about xiaomiphone");
    }

    @Test
    void contextLoads4() {
        //header需要键值对完全匹配
        Message nameMsg = MessageBuilder.withBody("hello pealipala".getBytes()).setHeader("name","pealipala").build();
        Message ageMsg = MessageBuilder.withBody("hello pealipala".getBytes()).setHeader("age","22").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,nameMsg);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,ageMsg);
    }

}
