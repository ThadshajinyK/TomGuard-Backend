package tomguradbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import tomguradbackend.constants.Constants;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendResetEmail(String toEmail , String subject , String link,byte[] attachmentBytes) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setFrom(Constants.MAIL_SERVER);
        helper.addAttachment("document.pdf", new ByteArrayDataSource(attachmentBytes, "application/pdf"));

        Context context = new Context();
        context.setVariable("resetLink", link);

        String emailContent = templateEngine.process("reset-password", context);
        helper.setText(emailContent, true);

        javaMailSender.send(message);

    }
}
