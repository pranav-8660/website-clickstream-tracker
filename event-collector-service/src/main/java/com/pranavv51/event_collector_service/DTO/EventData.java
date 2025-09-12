package com.pranavv51.event_collector_service.DTO;

import java.util.List;
import java.util.Map;

public class EventData {

    private List<Map<String,String>> eventInfo;

    public EventData(List<Map<String, String>> eventInfo) {
        this.eventInfo = eventInfo;
    }

    public List<Map<String, String>> getEventInfo(){
        return this.eventInfo;
    }
}
