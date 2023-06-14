package com.management.communication.smtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

   @Autowired
   private JavaMailSender mailSender;

   private final String SUBJECT_EMAIL = "Order Status";

   public void sendEmail(String email, String messageText){

       SimpleMailMessage message = new SimpleMailMessage();

       message.setTo(email);
       message.setText(messageText);
       message.setSubject(SUBJECT_EMAIL);

       mailSender.send(message);
   }


}
