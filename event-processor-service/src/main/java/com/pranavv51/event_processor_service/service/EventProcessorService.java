package com.pranavv51.event_processor_service.service;

import com.pranavv51.event_processor_service.DTO.Location;
import com.pranavv51.event_processor_service.service.datacleaner.ClassifyBasedOnGeoIP;
import com.pranavv51.event_processor_service.service.datacleaner.NullValuesChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


@Service
public class EventProcessorService {


    @Autowired
    private NullValuesChecker nullValuesChecker;

    @Autowired
    private ClassifyBasedOnGeoIP classifyBasedOnGeoIP;

    private Logger logger = LoggerFactory.getLogger(EventProcessorService.class);

    private Location location;

    private HashMap<String,Object> getHashMapOfEvents(Map<String,Object> rawEvent){
        HashMap<String,Object> eventMap = new HashMap<>();
        eventMap.put("websiteId",rawEvent.get("websiteId"));
        eventMap.put("eventType",rawEvent.get("eventType"));
        eventMap.put("eventData",rawEvent.get("eventData"));
        eventMap.put("timeStamp",rawEvent.get("timeStamp"));
        eventMap.put("ipOrDns",rawEvent.get("ipOrDns"));
        eventMap.put("userAgent",rawEvent.get("userAgent"));
        eventMap.put("endPoint",rawEvent.get("endPoint"));
        return eventMap;
    }

    public Map<String,Object> processEventsRawToEnriched(Map<String,Object> rawEvents){
        // (TODO : process all the events)

        HashMap<String,Object> eventMap = getHashMapOfEvents(rawEvents);

        //data cleaning for checking if all values are present, if not we will add default values.
        eventMap = nullValuesChecker.allFieldsPresent(eventMap);
        if(!(nullValuesChecker.getAllFieldsPresent())) logger.info("Null values present for "+rawEvents+", hence some default values are being added to the raw event.");

        //enrichment of data. pending with GeoIP, UserAgent parsing, session metadata, processedAt timestamp

        //processedAt timestamp->
        eventMap.put("processedAt",Instant.now());

        // classify based on location
        Location locationBasedOnIp = classifyBasedOnGeoIP.getTheGeoLocationOfIp(eventMap.get("ipOrDns").toString());

        eventMap.put("Location",locationBasedOnIp);

        return eventMap ;
    }


}
