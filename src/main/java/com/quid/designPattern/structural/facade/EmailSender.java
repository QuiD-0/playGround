package com.quid.designPattern.structural.facade;

public class EmailSender {

    private EmailSetting emailSetting;
    private EmailMessage emailMessage;

    public EmailSender(EmailSetting emailSetting, EmailMessage emailMessage) {
        this.emailSetting = emailSetting;
        this.emailMessage = emailMessage;
    }

    public void sendEmail() {
        System.out.println("Sending email to " + emailMessage.getTo() + " with message " + emailMessage.getContent());
        System.out.println("protocol: " + emailSetting.getProtocol());
        System.out.println("host: " + emailSetting.getHost());
        System.out.println("port: " + emailSetting.getPort());

    }

}
