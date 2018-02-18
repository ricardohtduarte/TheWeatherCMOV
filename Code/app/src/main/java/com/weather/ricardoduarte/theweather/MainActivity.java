package com.weather.ricardoduarte.theweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.weather.ricardoduarte.theweather.weatherService.Model.City;
import com.weather.ricardoduarte.theweather.weatherService.Service.WeatherClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//http://api.apixu.com/v1/current.json?key=07e921a3441f4e148e201522181702&q=Paris
public class MainActivity extends AppCompatActivity {

    TextView city;
    String base_url =  "http://api.apixu.com/v1/";
    String api_key = "07e921a3441f4e148e201522181702";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = findViewById(R.id.city_id);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        WeatherClient weatherClient = retrofit.create(WeatherClient.class);

        Call<City> call = weatherClient.cityInfo(api_key, "Paris");

        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {

                Log.i("Test", new Gson().toJson(response));

            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Log.i("Test", "onFailure");
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });

        String text = "comes from resquest";
        changeTextView(city, text);
    }

    private void changeTextView(TextView city, String text){
        city.setText(text);

    }
}
