package com.mosin.myweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static final String log = "Запись лога";
private final String tempDataKey = "Temp";
private TextView showTemp;
private Button changeTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(log, "onCreate");
        findViews();
        setOnButtonClickBehaviour();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d(log, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d(log, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d(log, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d(log, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(log, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        String tempOreint = showTemp.getText().toString();
        saveInstanceState.putString(tempDataKey, tempOreint);
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String temp = savedInstanceState.getString(tempDataKey);
        showTemp.setText(temp);
    }

    private void findViews(){
        showTemp  = findViewById(R.id.temperature);
        changeTemp = findViewById(R.id.changeBtn);
    }

    private void setOnButtonClickBehaviour(){
        changeTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thisTemp = Integer.parseInt(showTemp.getText().toString());
                String newTemp = String.valueOf(++thisTemp);
                showTemp.setText(newTemp);
                Log.i(log, "Температура изменена" + " " + newTemp);
                Toast.makeText(getApplicationContext(), getString(R.string.chengingTemp) + " " + newTemp, Toast.LENGTH_SHORT).show();
            }
        });
    }
}



