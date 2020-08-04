package com.mosin.myweather;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button toFindCityBtn, infoCityBtn, infoYandexBtn;
    private TextView textViewCity;
    private ImageView settingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setBtnToFindCityOnClick();
        showFromFindCityActivity();
        showSettingBtnOnClick();
        showInfoCityBtnOnClick();
        showInfoYandexOnClick();
    }

    private void findViews(){
        toFindCityBtn = findViewById(R.id.findCityBtn);
        textViewCity = findViewById(R.id.city);
        settingBtn = findViewById(R.id.icoSetting);
        infoCityBtn = findViewById(R.id.infoCity);
        infoYandexBtn = findViewById(R.id.yandex);
    }

    private void setBtnToFindCityOnClick(){
        toFindCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindCity.class);
                startActivity(intent);
            }
        });
    }

    private void showFromFindCityActivity(){
        String city = getIntent().getStringExtra(FindCity.cityKey);
        textViewCity.setText(city);
    }

    private void showSettingBtnOnClick(){
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Setting.class);
                startActivity(intent);
            }
        });
    }

    private void showInfoCityBtnOnClick() {
        infoCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://ru.wikipedia.org/wiki/" + textViewCity.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void showInfoYandexOnClick() {
        infoYandexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://yandex.ru/pogoda/" + textViewCity.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

}



