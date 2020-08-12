package com.mosin.myweather;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCityActivity extends AppCompatActivity {
    private TextView cityText, showTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farms);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViews();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            FragmentShowCity details = new FragmentShowCity();
            details.setArguments(getIntent().getExtras());
            String [] cityChoice = getResources().getStringArray(R.array.city_names);
            String [] tempArr = getResources().getStringArray(R.array.temps);
            cityText.setText(cityChoice[details.getIndex()]);
            showTemp.setText(tempArr[details.getIndex()]);
        }
    }
    public void findViews(){
        cityText = findViewById(R.id.cityNameView);
        showTemp = findViewById(R.id.tempView);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}

