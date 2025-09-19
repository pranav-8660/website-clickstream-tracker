package com.pranavv51.event_processor_service.service.datacleaner;


import com.pranavv51.event_processor_service.DTO.Location;
import org.springframework.stereotype.Service;

@Service
public class ClassifyBasedOnGeoIP {



    // TODO - should get the account-id and the api key of maxmind....

    // will code this part once i get the api key and the account id

    private Location queryMaxMindForGeoClassificationOfIP(String ip){

        //implementing this after getting the access key and the secret access key from maxmind
        return new Location();
    }

    public Location getTheGeoLocationOfIp(String ip){
        return queryMaxMindForGeoClassificationOfIP(ip);
    }

}
