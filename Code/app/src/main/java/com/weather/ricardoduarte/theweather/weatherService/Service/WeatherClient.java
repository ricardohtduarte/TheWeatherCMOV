package com.weather.ricardoduarte.theweather.weatherService.Service;

import com.weather.ricardoduarte.theweather.weatherService.Model.City;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ricardoduarte on 17/02/2018.
 */

//http://api.apixu.com/v1/current.json?key=07e921a3441f4e148e201522181702&q=Paris

public interface WeatherClient {
    @GET("current.json?")
    Call<City> cityInfo(@Query("key") String key, @Query("q") String city);
}
