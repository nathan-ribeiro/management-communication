package com.management.communication.amqp.listener;

import com.management.communication.domain.dto.MessageDTO;
import com.management.communication.service.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    private MessageService messageService;

    @RabbitListener(queues = "message.communication")
    public void getMessage(MessageDTO message){
        System.out.println("MessageListener - getMessage, body: " + message.toString());

        messageService.communicationOrderStatus(message);
    }

}
