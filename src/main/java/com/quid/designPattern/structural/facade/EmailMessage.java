package com.quid.designPattern.structural.facade;

import lombok.Getter;
@Getter
public class EmailMessage {

    private String from;
    private String to;
    private String subject;
    private String content;

    public EmailMessage(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

}
