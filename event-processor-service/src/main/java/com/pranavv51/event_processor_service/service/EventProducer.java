package com.pranavv51.event_processor_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventProducer {

    @Value("${app.kafka.topic:processed-events}")
    private String topic;

    Logger logger = LoggerFactory.getLogger(EventProducer.class);

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKafkaStringObjectMap(Map<String,Object> eventProcessedToBeProduced,String websiteId){
        kafkaTemplate.send(topic,websiteId,eventProcessedToBeProduced);
        logger.info(" Enriched Event "+eventProcessedToBeProduced+" processed to processed-events topics");
    }
}
