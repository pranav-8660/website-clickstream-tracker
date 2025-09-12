package com.pranavv51.event_collector_service.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ECSController {

    @PostMapping(value = "/track")
    public void readIncomingEvents(){

    }


}
