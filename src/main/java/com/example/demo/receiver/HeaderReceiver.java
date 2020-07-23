package com.example.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 22:52
 */
@Component
public class HeaderReceiver {
    @RabbitListener(queues = "queue-name")
    public void handleName(byte[] msg){
        System.out.println("handleName>>>"+new String(msg,0,msg.length));
    }

    @RabbitListener(queues = "queue-age")
    public void handleAge(byte[] msg){
        System.out.println("handleAge>>>"+new String(msg,0,msg.length));
    }
}
