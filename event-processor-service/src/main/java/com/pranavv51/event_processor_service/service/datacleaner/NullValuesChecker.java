package com.pranavv51.event_processor_service.service.datacleaner;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;

record UserAgent(String browser,String os){ }

@Service
public class NullValuesChecker {

    private boolean areAllFieldsPresent=true;

    public boolean getAllFieldsPresent(){return this.areAllFieldsPresent; }

    public HashMap<String,Object> allFieldsPresent(HashMap<String,Object> rawEvent){


        if(rawEvent.get("websiteId")==null){
            rawEvent.put("websiteId","NaN");
            areAllFieldsPresent=false;
        }
        if(rawEvent.get("eventType")==null){
            rawEvent.put("eventType","general-event");
            areAllFieldsPresent=false;
        }
        if(rawEvent.get("eventData")==null){
            rawEvent.put("eventData","no-information");
            areAllFieldsPresent=false;
        }
        if(rawEvent.get("timeStamp")==null){
            rawEvent.put("timeStamp", Instant.EPOCH);
            areAllFieldsPresent=false;
        }
        if(rawEvent.get("ipOrDns")==null){
            rawEvent.put("ipOrDns", "0.0.0.0");
            areAllFieldsPresent=false;
        }
        if(rawEvent.get("userAgent")==null){
            rawEvent.put("userAgent", new UserAgent("Unknown","Unknown"));
            areAllFieldsPresent=false;
        }
        if(rawEvent.get("endPoint")==null){
            rawEvent.put("endPoint","/home");
            areAllFieldsPresent=false;
        }

        return rawEvent;
    }
}
