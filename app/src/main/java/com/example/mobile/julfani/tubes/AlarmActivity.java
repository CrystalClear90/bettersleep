package com.example.mobile.julfani.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        findViewById(R.id.exit_button).setOnClickListener(this::launchMainActivity);
        findViewById(R.id.start_sleeping).setOnClickListener(this::launchSleepingActivity);
    }

    public void launchMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchSleepingActivity(View view){
        Intent intent = new Intent(this, SleepActivity.class);
        startActivity(intent);
    }
}