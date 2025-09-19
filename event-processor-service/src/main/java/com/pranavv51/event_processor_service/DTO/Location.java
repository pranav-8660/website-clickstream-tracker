package com.pranavv51.event_processor_service.DTO;

public class Location {

    private String country;
    private String city;
    private String latitude;
    private String longitude;

    public Location(String country, String city, String latitude, String longitude) {
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "Country: "+this.country+". City: "+this.city+". Latitude: "+this.latitude+". Longitude: "+this.longitude;
    }
}
