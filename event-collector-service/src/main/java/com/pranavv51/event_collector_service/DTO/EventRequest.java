package com.pranavv51.event_collector_service.DTO;

import java.time.Instant;

public class EventRequest {

    private long websiteId;
    private String eventType;
    private EventData eventData;
    private Instant timeStamp;
    private String ipOrDns;
    private UserAgent userAgent;
    private String endPoint;

    //newly added ones->
    private String screenResolution;
    private String locale;


    public EventRequest(long websiteId,String eventType, EventData eventData,String endPoint,String screenResolution,String locale) {
        this.eventType = eventType;
        this.eventData = eventData;
        this.websiteId = websiteId;
        this.endPoint = endPoint;
        //new ones
        this.locale=locale;
        this.screenResolution=screenResolution;
    }

    public String getEventType() {
        return eventType;
    }

    public EventData getEventData() {
        return eventData;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public String getIpOrDns() {
        return ipOrDns;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public long getWebsiteId(){
        return this.websiteId;
    }

    public void setIpOrDns(String ip){
        this.ipOrDns=ip;
    }

    public void setUserAgent(UserAgent userAgent){
        this.userAgent=userAgent;
    }

    public void setTimeStamp(Instant timeStamp){
        this.timeStamp=timeStamp;
    }

    public String getEndPoint(){
        return this.endPoint;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public String getLocale() {
        return locale;
    }
}
