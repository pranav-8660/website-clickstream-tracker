package com.pranavv51.event_processor_service.config;


import com.maxmind.geoip2.DatabaseReader;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class GeoIpConfig {

    public DatabaseReader databaseReader() throws IOException {
        File dbFileForMaxMindGeoIpConfigurer = new File(getClass().getClassLoader().getResource("GeoLite2-City.mmdb").getFile());
        return new DatabaseReader.Builder(dbFileForMaxMindGeoIpConfigurer).build();
    }
}
