package com.pranavv51.event_processor_service.service.datacleaner;


import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.pranavv51.event_processor_service.DTO.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class ClassifyBasedOnGeoIP {

    @Autowired
    private DatabaseReader databaseReader;

    private Location queryMaxMindForGeoClassificationOfIP(String ip) {



        Location locationFromIp;

        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            CityResponse cityResponse = databaseReader.city(ipAddress);

            locationFromIp = new Location(cityResponse.getCountry().toString(),cityResponse.getCity().toString(),cityResponse.getLocation().getLatitude().toString(),cityResponse.getLocation().getLatitude().toString());
            return locationFromIp;
        } catch (UnknownHostException e) {
            return new Location("Unknown","Unknown","Unknown","Unknown");
        } catch (IOException e) {
            return new Location("Unknown","Unknown","Unknown","Unknown");
        } catch (GeoIp2Exception e) {
            return new Location("Unknown","Unknown","Unknown","Unknown");
        }

    }

    public Location getTheGeoLocationOfIp(String ip){
        return queryMaxMindForGeoClassificationOfIP(ip);
    }

}
