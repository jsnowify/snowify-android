package com.example.snowify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String userName = getIntent().getStringExtra("username");

        // Capitalize the first letter of the username
        if (userName != null && !userName.isEmpty()) {
            userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
        }

        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome, " + userName + "!");

        TextView toCamera;
        toCamera = findViewById(R.id.toCamera);
        toCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        TextView toMap;
        toMap = findViewById(R.id.toMap);
        toMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, MapActivity.class);
                startActivity(intent);
            }
        });

        TextView toWeather;
        toWeather = findViewById(R.id.toWeather);
        toWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Welcome.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

    }
}