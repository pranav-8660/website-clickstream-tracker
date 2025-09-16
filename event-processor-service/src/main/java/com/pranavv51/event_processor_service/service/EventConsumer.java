package com.pranavv51.event_processor_service.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class EventConsumer {

    @Autowired
    private final EventProducer eventProducer;

    @Autowired
    private final EventProcessorService eventProcessorService;

    Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    public EventConsumer(EventProducer eventProducer, EventProcessorService eventProcessorService) {
        this.eventProducer = eventProducer;
        this.eventProcessorService = eventProcessorService;
    }


    //this method consumes from clickstream-events and then produces to processed-events
    @KafkaListener(topics = "${app.kafka.input-topic}", groupId = "event-processor-group")
    public void consumer(Map<String,Object> rawEvent){

        logger.info("Consumed the raw event :-"+rawEvent);

        //call the processor to process raw events to enriched events
        Map<String,Object> enrichedEvent = eventProcessorService.processEventsRawToEnriched(rawEvent);

        //call the producer to send the enriched events to processed-events topic
        eventProducer.sendKafkaStringObjectMap(enrichedEvent,rawEvent.get("websiteId").toString());

    }


}
