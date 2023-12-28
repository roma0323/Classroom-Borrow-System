package com.example.servingwebcontent.LuXuaU.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public String contentGenerator(String newPassword){
        String res = "";
        res += "您的密碼已經重設為: ";
        res += newPassword;
        return res;
    }

    public void sendPlainText(String receiver, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom("教室/設備借用系統<ncu.classroom.borrow@gmail.com>");

        mailSender.send(message);
    }
}
