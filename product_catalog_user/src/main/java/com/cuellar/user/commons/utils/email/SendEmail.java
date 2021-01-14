package com.cuellar.user.commons.utils.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmail implements ISendEmail{

    @Autowired
    private JavaMailSender sender;

    public boolean sendEmailTool(Long textMessage, String email) {
        boolean send = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText("Se generó el siguiente código: " + textMessage, true);
            helper.setSubject("Código de verificación");
            sender.send(message);
            send = true;
            return send;
        } catch (MessagingException e) {
            return send;
        }
    }

    @Override
    public boolean sendEmail(Long textMessage, String email) {
        return sendEmailTool(textMessage,email);
    }
}
