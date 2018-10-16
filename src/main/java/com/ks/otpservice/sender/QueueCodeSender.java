package com.ks.otpservice.sender;

import com.ks.otpservice.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueCodeSender implements CodeSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String routingkey, Message message) {
           rabbitTemplate.convertAndSend(message);
    }
}
