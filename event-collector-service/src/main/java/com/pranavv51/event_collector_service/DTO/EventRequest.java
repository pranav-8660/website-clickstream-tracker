package com.pranavv51.event_collector_service.DTO;

import java.time.Instant;

public class EventRequest {

    private long websiteId;
    private String eventType;
    private EventData eventData;
    private Instant timeStamp;
    private String ipOrDns;
    private String userAgent;

    public EventRequest(long websiteId,String eventType, EventData eventData) {
        this.eventType = eventType;
        this.eventData = eventData;
        this.timeStamp = timeStamp;
        this.websiteId = websiteId;
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

    public String getUserAgent() {
        return userAgent;
    }

    public long getWebsiteId(){
        return this.websiteId;
    }

    public void setIpOrDns(String ip){
        this.ipOrDns=ip;
    }

    public void setUserAgent(String userAgent){
        this.userAgent=userAgent;
    }

    public void setTimeStamp(Instant timeStamp){
        this.timeStamp=timeStamp;
    }
}
