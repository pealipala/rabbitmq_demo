package com.example.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 21:45
 */
@Component
public class FanOutReceiver {

    @RabbitListener(queues = "queue-one")
    public void handleOne(String msg){
        System.out.println("handleOne>>>"+msg);
    }

    @RabbitListener(queues = "queue-two")
    public void handleTwo(String msg){
        System.out.println("handleTwo>>>"+msg);
    }
}
