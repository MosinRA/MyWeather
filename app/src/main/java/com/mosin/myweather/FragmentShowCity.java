package com.mosin.myweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentShowCity extends Fragment {
    private TextView showCity, showTemp;

    static FragmentShowCity create(CoatContainer container) {
        FragmentShowCity fragment = new FragmentShowCity();
        Bundle args = new Bundle();
        args.putSerializable("index", container);
        fragment.setArguments(args);
        return fragment;
    }

    int getIndex() {
        CoatContainer coatContainer = (CoatContainer) (Objects.requireNonNull(getArguments())
                .getSerializable("index"));
        try {
            return coatContainer.position;
        } catch (Exception e) {
            return 0;
        }
    }

    String getCityName() {
        CoatContainer coatContainer = (CoatContainer) (Objects.requireNonNull(getArguments())
                .getSerializable("index"));
        try {
            return coatContainer.cityName;
        } catch (Exception e) {
            return "";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_city_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] tempArr = getResources().getStringArray(R.array.temps);
        initViews(view);
        showCity.setText(getCityName());
        showTemp.setText(tempArr[getIndex()]);
    }

    public void initViews(View view) {
        showCity = view.findViewById(R.id.cityName);
        showTemp = view.findViewById(R.id.show_temp);
    }
}
