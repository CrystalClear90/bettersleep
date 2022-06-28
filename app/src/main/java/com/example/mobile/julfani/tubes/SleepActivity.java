package com.example.mobile.julfani.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class SleepActivity extends AppCompatActivity {
    private TextView currentTimeTextView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        findViewById(R.id.end_sleep).setOnClickListener(this::launchMainActivity);
        runClock();
    }

    public void launchMainActivity (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void runClock(){
        currentTimeTextView =findViewById(R.id.current_time);

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