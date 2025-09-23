package com.pranavv51.event_processor_service.service.datacleaner;


import com.pranavv51.event_processor_service.DTO.SessionMetaData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckOnSessionMetaData {

    //TODO
    private Map<String,Object> processTheSessionMetadata(Map<String,Object> clickstreamEvent){
        var sessionMetaData = (SessionMetaData) clickstreamEvent.get("sessionMetaData");
        if(sessionMetaData.getSessionId()==null){
            sessionMetaData.setSessionId("invalid");
        }
        if(sessionMetaData.getLocale()==null){
            sessionMetaData.setLocale("invalid");
        }
        if(sessionMetaData.getScreenResolution()==null){
            sessionMetaData.setScreenResolution("0x0");
        }
        if(sessionMetaData.getReferrer()==null){
            sessionMetaData.setReferrer("www.google.com/");
        }
        clickstreamEvent.put("sessionMetaData",sessionMetaData);
        return clickstreamEvent;
    }


}
