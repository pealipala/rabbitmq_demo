package com.example.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 22:31
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "xiaomi")
    public void handleXiaomi(String msg){
        System.out.println("handleXiaomi>>>"+msg);
    }

    @RabbitListener(queues = "apple")
    public void handleApple(String msg){
        System.out.println("handleApple>>>"+msg);
    }

    @RabbitListener(queues = "phone")
    public void handlePhone(String msg){
        System.out.println("handlePhone>>>"+msg);
    }
}
