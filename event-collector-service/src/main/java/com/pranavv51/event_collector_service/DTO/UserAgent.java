package com.pranavv51.event_collector_service.DTO;

public class UserAgent {

    private String browser;
    private String os;

    public UserAgent(String browser,String os){
        this.browser=browser;
        this.os=os;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOs() {
        return os;
    }
}
