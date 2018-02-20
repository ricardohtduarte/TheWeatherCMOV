package com.weather.ricardoduarte.theweather.weatherService.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ricardoduarte on 20/02/2018.
 */

public class CityResponse {
    @SerializedName("location")
    private Location location;
    @SerializedName("current")
    private Current current;

    public CityResponse(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }
}

class Location{
    @SerializedName("name")
    String name;
    @SerializedName("region")
    String region;
    @SerializedName("country")
    String country;
    @SerializedName("lat")
    float lat;
    @SerializedName("lon")
    float lon;

    public Location(String name, String region, String country, float lat, float lon) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
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

class Current{
    @SerializedName("temp_c")
    float temp_c;

    public Current(float temp_c) {
        this.temp_c = temp_c;
    }

    public float getTemp_c() {
        return temp_c;
    }
}