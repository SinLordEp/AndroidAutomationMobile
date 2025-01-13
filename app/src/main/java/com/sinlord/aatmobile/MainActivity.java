package com.sinlord.aatmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startServiceButton = findViewById(R.id.startServiceButton);
        Button stopServiceButton = findViewById(R.id.stopServiceButton);

        startServiceButton.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(MainActivity.this, MainService.class);
            startService(serviceIntent);
        });

        stopServiceButton.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(MainActivity.this, MainService.class);
            stopService(serviceIntent);
        });
    }
}
