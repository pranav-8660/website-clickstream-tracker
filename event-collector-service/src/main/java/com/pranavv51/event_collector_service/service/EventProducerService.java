package com.pranavv51.event_collector_service.service;

import com.pranavv51.event_collector_service.DTO.EventRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventProducerService {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${app.kafka.topic:clickstream-events}")
    private String topic;

    public EventProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(EventRequest event , String userAgent){
        Map<String,Object> kafkaStringObjectMap = new HashMap<>();

        kafkaStringObjectMap.put("websiteId",event.getWebsiteId());
        kafkaStringObjectMap.put("eventType",event.getEventType());
        kafkaStringObjectMap.put("eventData",event.getEventData());
        kafkaStringObjectMap.put("timeStamp",event.getTimeStamp());
        kafkaStringObjectMap.put("ipOrDns",event.getIpOrDns());
        kafkaStringObjectMap.put("userAgent",event.getUserAgent());

        kafkaTemplate.send(topic,String.valueOf(event.getWebsiteId()),kafkaStringObjectMap);

    }

}
