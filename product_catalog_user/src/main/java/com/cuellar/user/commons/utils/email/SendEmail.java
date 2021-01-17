package com.cuellar.user.commons.utils.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmail implements ISendEmail{

    @Autowired
    private JavaMailSender sender;

    public void sendEmailTool(Long textMessage, String email) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText("Se generó el siguiente código: " + textMessage, true);
            helper.setSubject("Código de verificación");
            sender.send(message);
        } catch (MessagingException ignored) {
        }
    }

    @Override
    @Async
    public void sendEmail(Long textMessage, String email) {
         sendEmailTool(textMessage,email);
    }
}
