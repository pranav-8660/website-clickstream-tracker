package com.pranavv51.storage_service.service;


import com.pranavv51.storage_service.model.ProcessedEventModel;
import com.pranavv51.storage_service.repository.ProcessedEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProcessedEventConsumer {


    private final ProcessedEventRepository processedEventRepository;

    public ProcessedEventConsumer(ProcessedEventRepository processedEventRepository) {
        this.processedEventRepository = processedEventRepository;
    }

    Logger logger = LoggerFactory.getLogger(ProcessedEventConsumer.class);

    public void consume(Map<String,Object> event){
        this.logger.info("Consumed an enriched event "+event+" from processed event topic.");
        this.processedEventRepository.save(new ProcessedEventModel(event));
    }
}
