package com.pranavv51.event_collector_service.DTO;

import java.util.List;
import java.util.Map;

public class EventData {

    private List<Map<String,Object>> eventInfo;

    public EventData(List<Map<String, Object>> eventInfo) {
        this.eventInfo = eventInfo;
    }

    public List<Map<String, Object>> getEventInfo(){
        return this.eventInfo;
    }
}
