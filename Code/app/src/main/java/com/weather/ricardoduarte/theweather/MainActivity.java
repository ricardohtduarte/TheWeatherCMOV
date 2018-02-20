package com.weather.ricardoduarte.theweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.weather.ricardoduarte.theweather.weatherService.Models.CityResponse;
import com.weather.ricardoduarte.theweather.weatherService.Service.WeatherClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//http://api.apixu.com/v1/current.json?key=07e921a3441f4e148e201522181702&q=Paris
public class MainActivity extends AppCompatActivity {

    TextView city;
    ListView city_list;
    Button add_city;
    String base_url =  "http://api.apixu.com/v1/";
    String api_key = "07e921a3441f4e148e201522181702";
    List<CityResponse> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        build_retrofit();

    }



    private void build_retrofit(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        WeatherClient weatherClient = retrofit.create(WeatherClient.class);

        Call<CityResponse> call = weatherClient.cityInfo(api_key, "Paris");

        call.enqueue(new Callback<CityResponse> () {
            @Override
            public void onResponse(Call<CityResponse>  call, Response<CityResponse>  response) {
                Log.i("TESTE", "dDEU");
            }
            @Override
            public void onFailure(Call<CityResponse>  call, Throwable t) {
                Log.i("Test", "REQUEST FAILED: " + t.getMessage());
            }
        });
    }

    private void request_city(String name){

    }


  /*  private void create_listview(){
        CityResponse city1 = new CityResponse("Paris", 21);
        CityResponse city2 = new CityResponse("Lisbon", 24);

        cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);

        ListAdapter city_list_adapter = new ListCityAdapter(this, cities);
        city_list = findViewById(R.id.city_list);
        city_list.setAdapter(city_list_adapter);
    }*/
}
