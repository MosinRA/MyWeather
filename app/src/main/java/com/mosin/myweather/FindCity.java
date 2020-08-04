package com.mosin.myweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class FindCity extends AppCompatActivity {
    final static String cityKey = "city";
    private ImageView enterBtn;
    private EditText findCity;
    private ImageView settingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_city);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViews();
        setEnterBtnOnClick();
        showSettingBtn();
    }

    public void findViews(){
        enterBtn = findViewById(R.id.icoEnter);
        findCity = findViewById(R.id.serchCity);
        settingBtn = findViewById(R.id.icoSetting);
    }

    public void setEnterBtnOnClick(){
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindCity.this, MainActivity.class);
                String city = findCity.getText().toString();
                intent.putExtra(cityKey, city);
                startActivity(intent);
            }
        });
    }

    private void showSettingBtn(){
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindCity.this, Setting.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}