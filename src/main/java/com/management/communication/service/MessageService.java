package com.management.communication.service;

import com.management.communication.domain.dto.MessageDTO;
import com.management.communication.smtp.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {

    @Autowired
    private EmailSender emailSender;

    private final String DEFAULT_MESSAGE_TEXT = "Hello ?1, your order ?2 status has been updated, actual status: ";

    public void communicationOrderStatus(MessageDTO messageDTO){

        log.info("MessageService - communicationOrderStatus START");

        String messageText = DEFAULT_MESSAGE_TEXT + messageDTO.getStatus();
        messageText = messageText.replace("?1", messageDTO.getName());
        messageText = messageText.replace("?2", messageDTO.getOrderID());
        log.info("MessageText to send: " + messageText);

        emailSender.sendEmail(messageDTO.getEmail(), messageText);

        log.info("MessageService - communicationOrderStatus END");
    }
}
