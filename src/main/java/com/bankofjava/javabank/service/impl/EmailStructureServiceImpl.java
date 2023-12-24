package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailStructureServiceImpl implements EmailStructureService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailStructure) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailStructure.getRecipient());
            mailMessage.setText(emailStructure.getMessageBody());
            mailMessage.setSubject(emailStructure.getSubject());

            javaMailSender.send(mailMessage);
            System.out.println("mail sent successfully");
        } catch (MailException mailException) {
        throw new RuntimeException(mailException);
        }
    }
}
