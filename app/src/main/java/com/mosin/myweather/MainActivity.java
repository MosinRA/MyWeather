package com.mosin.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView settingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findSettingView();
        setOnSettingViewOnClickBehavior();
    }

    private void findSettingView() {
        settingView = findViewById(R.id.icoSetting);
    }

    private void setOnSettingViewOnClickBehavior() {
        settingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(getApplication(), SettingActivity.class );
                startActivity(i);
            }

        });
    }


}


