package com.example.user_service.servcie;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

  public void sendMail(String toMail,String otp,String message){
      SimpleMailMessage messaege = new SimpleMailMessage();
      messaege.setTo("");
      messaege.setSubject("regstration");
      messaege.setFrom("your email ");
      messaege.setText("message");
      javaMailSender.send(messaege);
      System.out.println("email send sucess");
  }


}
