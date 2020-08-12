package com.mosin.myweather;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class FragmentChoiceCity extends Fragment {
    private ListView cityNameListView;
    private TextView emptyTextView;
    private boolean isExistCoatOfCity;
    private int currentPosition = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choce_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initList();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isExistCoatOfCity = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("CurrentCity", 0);
        }
        if (isExistCoatOfCity) {
            cityNameListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCity();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("CurrentCity", currentPosition);
        super.onSaveInstanceState(outState);
    }

    public void initViews(View view) {
        cityNameListView = view.findViewById(R.id.city_name_list_view);
        emptyTextView = view.findViewById(R.id.cities_list_empty_view);
    }

    public void initList() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.city_names,
                android.R.layout.simple_list_item_activated_1);
        cityNameListView.setAdapter(adapter);
        cityNameListView.setEmptyView(emptyTextView);
        cityNameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                showCity();
            }
        });
    }

    private void showCity() {
        if (isExistCoatOfCity) {
            cityNameListView.setItemChecked(currentPosition, true);
            FragmentShowCity detail = (FragmentShowCity)
                    Objects.requireNonNull(getFragmentManager()).findFragmentById(R.id.show_city);
            if (detail == null || detail.getIndex() != currentPosition) {
                detail = FragmentShowCity.create(getCoatContainer());
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.show_city, detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(Objects.requireNonNull(getActivity()), ShowCityActivity.class);
            intent.putExtra("index", getCoatContainer());
            startActivity(intent);
        }
    }

    private CoatContainer getCoatContainer() {
        String[] cities = getResources().getStringArray(R.array.city_names);
        CoatContainer container = new CoatContainer();
        container.position = currentPosition;
        container.cityName = cities[currentPosition];
        return container;
    }
}
