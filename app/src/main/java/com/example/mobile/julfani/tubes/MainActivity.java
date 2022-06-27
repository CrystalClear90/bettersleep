package com.example.mobile.julfani.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView currentTimeTextView;
    private int hours;
    private int minutes;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_sleeping).setOnClickListener(this::launchSleepingActivity);
        findViewById(R.id.alarm_button).setOnClickListener(this::launchAlarmActivity);
        currentTimeTextView =findViewById(R.id.current_time);
        runClock();
    }

    public void launchAlarmActivity(View view){
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

    public void launchSleepingActivity(View view){
        Intent intent = new Intent(this, SleepActivity.class);
        startActivity(intent);
    }

    private void runClock(){
        handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = Calendar.getInstance().get(Calendar.HOUR);
                int minutes = Calendar.getInstance().get(Calendar.MINUTE);

                String time = String.format(Locale.getDefault(), "%02d : %02d", hours, minutes);
                
                currentTimeTextView.setText(time);

                handler.postDelayed(this, 1000);
            }
        });
    }
}