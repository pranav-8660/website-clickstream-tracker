package com.pranavv51.event_collector_service.controller;


import com.pranavv51.event_collector_service.DTO.EventRequest;
import com.pranavv51.event_collector_service.service.EventProducerService;
import com.pranavv51.event_collector_service.service.SessionMetadataProcessor;
import com.pranavv51.event_collector_service.service.UserAgentProcessor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class ECSController {

    private final EventProducerService eventProducerService;
    private final UserAgentProcessor userAgentProcessor;
    private final SessionMetadataProcessor sessionMetadataProcessor;

    public ECSController(EventProducerService eventProducerService, UserAgentProcessor userAgentProcessor, SessionMetadataProcessor sessionMetadataProcessor) {
        this.eventProducerService = eventProducerService;
        this.userAgentProcessor = userAgentProcessor;
        this.sessionMetadataProcessor = sessionMetadataProcessor;
    }

    private void sendEventsToClickStreamEvents(List<EventRequest> nEventRequests,HttpServletRequest httpRequest){
        for(EventRequest eventRequest:nEventRequests){
            eventRequest.setIpOrDns(httpRequest.getRemoteAddr());
            eventRequest.setUserAgent(userAgentProcessor.getUserAgentProcessed(httpRequest.getHeader("User-Agent").toString()));
            eventRequest.setTimeStamp(Instant.now());

            eventProducerService.send(eventRequest,sessionMetadataProcessor.sessionMetadataProcessor(eventRequest.getLocale(),eventRequest.getScreenResolution(),httpRequest));
        }
    }

    @PostMapping(value = "/track")
    public void readIncomingEvents(@Valid  @RequestBody List<EventRequest> inputEventRequest, HttpServletRequest httpRequest){
        sendEventsToClickStreamEvents(inputEventRequest,httpRequest);
    }


}
