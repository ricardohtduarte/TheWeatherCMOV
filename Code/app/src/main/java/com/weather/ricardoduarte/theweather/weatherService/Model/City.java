package com.weather.ricardoduarte.theweather.weatherService.Model;

/**
 * Created by ricardoduarte on 17/02/2018.
 */

public class City {
    String name;
    String region;
    String country;
    float lat;
    float lon;
    float temperature;

    public City(String name, float temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public City(String name, String region, String country, float lat, float lon, float temperature) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}

