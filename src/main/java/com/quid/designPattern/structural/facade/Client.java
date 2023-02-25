package com.quid.designPattern.structural.facade;

import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void test() {

        EmailSetting emailSetting = new EmailSetting("smtp.gmail.com", "587", "smtp");
        EmailMessage emailMessage = new EmailMessage("quid", "wodnd101@naver.com", "Hello",
            "Hello World");

        EmailSender emailSender = new EmailSender(emailSetting, emailMessage);
        emailSender.sendEmail();
    }

}
