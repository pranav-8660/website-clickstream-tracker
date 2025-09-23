package com.pranavv51.event_collector_service.service;


import com.pranavv51.event_collector_service.DTO.SessionMetadata;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;

@Service
public class SessionMetadataProcessor {

    public SessionMetadata sessionMetadataProcessor(String locale, String screenResolution, HttpServletRequest httpRequest){
        String sessionId = httpRequest.getSession().getId().toString();
        String referrer = httpRequest.getHeader("Referer");

        return new SessionMetadata(sessionId,locale,screenResolution,referrer);
    }
}
