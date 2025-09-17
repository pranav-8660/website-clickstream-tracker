package com.pranavv51.storage_service.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Map;

@Document("processed-events")
public class ProcessedEventModel {

    @Id
    private String clickEventId;

    private Map<String,Object> data;

    public ProcessedEventModel(Map<String,Object> data){
        this.data = data;
    }

    public String getClickEventId(){
        return this.clickEventId;
    }

    public Map<String,Object> getData(){
        return this.data;
    }

}
