package com.pranavv51.event_collector_service.controller;


import com.pranavv51.event_collector_service.DTO.EventRequest;
import com.pranavv51.event_collector_service.service.EventProducerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RestController
public class ECSController {

    private final EventProducerService eventProducerService;

    public ECSController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @PostMapping(value = "/track")
    public void readIncomingEvents(@Valid  @RequestBody EventRequest inputEventRequest, HttpServletRequest httpRequest){
        inputEventRequest.setIpOrDns(httpRequest.getRemoteAddr());
        inputEventRequest.setUserAgent(httpRequest.getHeader("User-Agent"));
        inputEventRequest.setTimeStamp(Instant.now());
        eventProducerService.send(inputEventRequest);
    }


}
