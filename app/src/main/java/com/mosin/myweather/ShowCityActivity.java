package com.mosin.myweather;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCityActivity extends AppCompatActivity {
    private TextView cityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farms);
        findViews();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            FragmentShowCity details = new FragmentShowCity();
            details.setArguments(getIntent().getExtras());
            String [] cityChoi = getResources().getStringArray(R.array.city_names);
            cityText.setText(cityChoi[details.getIndex()].toString());
        }
    }
    public void findViews(){
        cityText = findViewById(R.id.CityName);
    }
}
