package com.TomGuard.Service;

import com.TomGuard.constants.Constants;
import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;




@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendResetEmail(String toEmail , String subject , String link) throws MessagingException {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setFrom(Constants.MAIL_SERVER);

        Context context = new Context();
        context.setVariable("resetLink", link);

        String emailContent = templateEngine.process("reset-password", context);
        helper.setText(emailContent, true);

        javaMailSender.send(message);

    }
}
