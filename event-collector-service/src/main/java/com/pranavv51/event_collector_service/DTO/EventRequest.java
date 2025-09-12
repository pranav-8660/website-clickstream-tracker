package com.pranavv51.event_collector_service.DTO;

import java.time.Instant;

public class EventRequest {

    private String eventType;
    private EventData eventData;
    private Instant timeStamp;
    private String ipOrDns;
    private String userAgent;

    public EventRequest(String eventType, EventData eventData, Instant timeStamp, String ipOrDns, String userAgent) {
        this.eventType = eventType;
        this.eventData = eventData;
        this.timeStamp = timeStamp;
        this.ipOrDns = ipOrDns;
        this.userAgent = userAgent;
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
}
