package com.weather.ricardoduarte.theweather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weather.ricardoduarte.theweather.weatherService.Model.City;

import java.util.List;

/**
 * Created by ricardoduarte on 18/02/2018.
 */

public class ListCityAdapter extends ArrayAdapter<City>{
    public ListCityAdapter(@NonNull Context context, List<City> cities) {
        super(context, R.layout.custom_city_item, cities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View custom_view = inflater.inflate(R.layout.custom_city_item, parent, false);

        //reference to elements from custom_view
        City city_item = getItem(position);
        TextView city_name = custom_view.findViewById(R.id.city_name);
        TextView city_temperature = custom_view.findViewById(R.id.city_temperature);

        city_name.setText(city_item.getName());
        city_temperature.setText(Float.toString(city_item.getTemperature()));
        return custom_view;
    }
}
