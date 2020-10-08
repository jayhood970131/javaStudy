package com.jayhood;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootAsynApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("萍萍好呀");

        mailMessage.setText("爱你");

        mailMessage.setFrom("183191342@qq.com");
        mailMessage.setTo("1125300820@qq.com");

        mailSender.send(mailMessage);

    }

    @Test
    void contextLoads2() throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("好好吃饭");
        helper.setText("<h1 style='color:green'>吃蔬菜!</h1><hr/><h2 style='color:red'>胡萝卜!</h2>", true);

        helper.addAttachment("pingping.jpg", new File("E:\\GoogleDownload\\爱上紫禁城.jpg"));

        helper.setFrom("183191342@qq.com");
        helper.setTo("1125300820@qq.com");

        mailSender.send(mimeMessage);

    }


}
