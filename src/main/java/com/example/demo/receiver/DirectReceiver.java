package com.example.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 21:08
 */
//消息消费者
@Component
public class DirectReceiver {

    @RabbitListener(queues = "hello")
    public void handleDirect(String msg){
        System.out.println("handleDirect>>>>"+msg);
    }
}
