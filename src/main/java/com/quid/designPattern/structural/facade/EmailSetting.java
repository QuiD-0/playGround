package com.quid.designPattern.structural.facade;

import lombok.Getter;

@Getter
public class EmailSetting {

    private String host;
    private String port;
    private String protocol;

    public EmailSetting(String host, String port, String protocol) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }
}
