package com.pranavv51.event_processor_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

record UserAgent(String browser,String os){ }

@Service
public class EventProcessorService {

    private boolean areAllFieldsPresent=true;

    private Logger logger = LoggerFactory.getLogger(EventProcessorService.class);


    private HashMap<String,Object> getHashMapOfEvents(Map<String,Object> rawEvent){
        HashMap<String,Object> eventMap = new HashMap<>();
        eventMap.put("websiteId",rawEvent.get("websiteId"));
        eventMap.put("eventType",rawEvent.get("eventType"));
        eventMap.put("eventData",rawEvent.get("eventData"));
        eventMap.put("timeStamp",rawEvent.get("timeStamp"));
        eventMap.put("ipOrDns",rawEvent.get("ipOrDns"));
        eventMap.put("userAgent",rawEvent.get("userAgent"));
        return eventMap;
    }

    

    private HashMap<String,Object> allFieldsPresent(HashMap<String,Object> rawEvent){


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
            rawEvent.put("userAgent", new UserAgent("Chrome","Windows 11"));
            areAllFieldsPresent=false;
        }

        return rawEvent;
    }


    public Map<String,Object> processEventsRawToEnriched(Map<String,Object> rawEvents){
        // (TODO : process all the events)

        HashMap<String,Object> eventMap = getHashMapOfEvents(rawEvents);

        //data cleaning for checking if all values are present, if not we will add default values.
        eventMap = allFieldsPresent(eventMap);
        if(!areAllFieldsPresent) logger.info("Null values present for"+rawEvents+", hence some default values are being added to the raw event.");

        //enrichment of data.





        return null ;
    }


}
